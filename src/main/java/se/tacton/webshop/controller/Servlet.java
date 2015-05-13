package se.tacton.webshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.tacton.webshop.Config;
import se.tacton.webshop.exception.WebshopException;
import se.tacton.webshop.model.Cart;
import se.tacton.webshop.model.CustomerInfo;

public class Servlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest inRequest, HttpServletResponse inResponse) throws ServletException, IOException
	{
		inResponse.setContentType("text/html");
		inResponse.setStatus(HttpServletResponse.SC_OK);
		
		RequestDispatcher reqDispatch = null;
		Config configService = Config.getInstance();

		if (inRequest.getParameter("cart") != null)
		{
			try
			{
				Cart cart = configService.getCart();
				CustomerInfo customer = configService.getCustomer(cart.getCustomerId());
				inRequest.setAttribute("cart", cart);
				inRequest.setAttribute("customer", customer);
				reqDispatch = inRequest.getRequestDispatcher("/cart.jsp");
				reqDispatch.forward(inRequest, inResponse);
			}
			catch (WebshopException e)
			{
				reqDispatch = inRequest.getRequestDispatcher("/error.jsp");
				inRequest.setAttribute("message", e.getMessage());
				reqDispatch.forward(inRequest, inResponse);
			}
		}
		else if (inRequest.getParameter("organization") != null)
		{
			reqDispatch = inRequest.getRequestDispatcher("/organization.jsp");
			inRequest.setAttribute("org", configService.getOrganizations());
			reqDispatch.forward(inRequest, inResponse);
		}
		else
		{
			reqDispatch = inRequest.getRequestDispatcher("/error.jsp");
			reqDispatch.forward(inRequest, inResponse);
		}
	}
}
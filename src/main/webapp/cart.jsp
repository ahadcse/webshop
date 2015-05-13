<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="se.tacton.webshop.model.*"%>
<%@ page import="se.tacton.webshop.model.product.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
	<body>
		<%
		if (request.getAttribute("cart") != null && request.getAttribute("customer") != null)
		{
			Cart cart = (Cart) request.getAttribute("cart");
			CustomerInfo customer = (CustomerInfo) request.getAttribute("customer");
		%>
	
		<div>
			Shopping Cart ID:
			<%=cart.getId()%>
		</div>
		<div>
			Customer Name:
			<%=customer.getName()%>
		</div>
		<div>
			Address:
			<%=customer.getAddress() %>
		</div>
		<div>
			Organization:
			<%=customer.getOrganization().getOrganization().toString() %>
		</div>
		<% for (Product product : cart.getProducts()){ %>
    	   <% out.println(product.getHtml()); %>
		<%}%>
		
        <%}%>
	</body>
</html>
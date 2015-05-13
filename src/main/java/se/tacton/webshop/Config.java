package se.tacton.webshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import se.tacton.webshop.exception.WebshopException;
import se.tacton.webshop.model.Cart;
import se.tacton.webshop.model.CustomerInfo;
import se.tacton.webshop.model.Organization;

public class Config
{
	private static Config instance = new Config();
	private String cartData = "";

	private Config()
	{
		try
		{
			this.cartData = IOUtils.toString(this.getClass().getResourceAsStream("/webshop.properties"), "UTF-8");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static Config getInstance()
	{
		return instance;
	}

	public Cart getCart()
	{
		JSONObject cartJson = new JSONObject(this.cartData);
		return new Cart().fromJson(cartJson);
	}

	public CustomerInfo getCustomer(String id) throws WebshopException
	{
		CustomerInfo customer = new CustomerInfo("123", new Organization<String>("Sub org 4"), "MyCustomer", "Smart Street 1122");
		if (!id.equalsIgnoreCase("123"))
			throw new WebshopException("Customer not found!");
		return customer;
	}

	public List<Organization<String>> getOrganizations()
	{
		List<Organization<String>> organizations = new ArrayList<Organization<String>>();
		Organization<String> rootOrg = new Organization<String>("Root Organization");
		Organization<String> subOrg1 = new Organization<String>("Sub Organization 1");
		Organization<String> subOrg4 = new Organization<String>("Sub Organization 4");
		Organization<String> subOrg2 = new Organization<String>("Sub Organization 2");
		Organization<String> subOrg3 = new Organization<String>("Sub Organization 3");

		rootOrg.setLevel(0);
		subOrg1.setLevel(1);
		subOrg2.setLevel(2);
		subOrg3.setLevel(2);
		subOrg4.setLevel(1);

		organizations.add(rootOrg);
		organizations.add(subOrg1);
		organizations.add(subOrg2);
		organizations.add(subOrg3);
		organizations.add(subOrg4);

		return organizations;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return null;
	}
}

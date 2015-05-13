package se.tacton.webshop.model;

public class CustomerInfo
{
	private String m_customerId;
	private Organization<String> m_organization;
	private String m_name;
	private String m_address;
	
	public CustomerInfo() {
    }

	public CustomerInfo(String inCustomerId, Organization<String> inOrganization, String inName, String inAddress)
	{
		this.m_customerId = inCustomerId;
		this.m_organization = inOrganization;
		this.m_name = inName;
		this.m_address = inAddress;
	}

	public String getCustomerId()
	{
		return m_customerId;
	}

	public Organization<String> getOrganization()
	{
		return m_organization;
	}

	public String getName()
	{
		return m_name;
	}

	public String getAddress()
	{
		return m_address;
	}

}

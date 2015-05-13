package se.tacton.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class Organization<T>
{
	private T m_org;

	private Organization<T> m_parentOrg;

	private List<Organization<T>> m_subOrg = new ArrayList<Organization<T>>();
	
	private int level;
	
	public Organization() {
    }

	public Organization(T inOrg)
	{
		this.m_org = inOrg;
	}

	public void addSubOrganization(T inSubOrg)
	{
		Organization<T> child = new Organization<T>(inSubOrg);
		child.m_parentOrg = this;
		this.m_subOrg.add(child);
	}

	public T getOrganization()
	{
		return m_org;
	}

	public Organization<T> getParent()
	{
		return m_parentOrg;
	}

	public List<Organization<T>> getSubOrganizations()
	{
		return m_subOrg;
	}

	public boolean isRoot()
	{
		return (this.m_parentOrg == null);
	}
		
	public int getLevel()
	{
		return level;
	}

	public void setLevel(int inLevel)
	{
		this.level = inLevel;
	}

	@Override
	public String toString()
	{
		return this.toString();
	}

}

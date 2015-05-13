package se.tacton.webshop.model.product;

import se.tacton.webshop.model.Attribute;

public abstract class ProductAttribute
{
	protected Attribute m_attribute;

	public ProductAttribute()
	{
	}
	
	public void setAttribute(Attribute inAttribute) {
        this.m_attribute = inAttribute;
    }
	
	public Attribute getAttribute()
	{
		return m_attribute;
	}
	
	public abstract String getHtml();
}

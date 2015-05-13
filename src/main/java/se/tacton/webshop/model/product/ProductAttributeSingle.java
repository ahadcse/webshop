package se.tacton.webshop.model.product;

import org.json.JSONObject;

import se.tacton.webshop.model.Attribute;
import se.tacton.webshop.model.AttributeValue;

public class ProductAttributeSingle extends ProductAttribute
{
	private AttributeValue m_value;

	public ProductAttributeSingle()
	{
	}

	public ProductAttributeSingle(Attribute inAttribute, AttributeValue inValue)
	{
		setAttribute(inAttribute);
		m_value = inValue;
	}

	public AttributeValue getValue()
	{
		return m_value;
	}

	@Override
	public String getHtml()
	{
		return ("<table>" + "<tr>" + "<td>" + this.getAttribute().getName() + ":&nbsp;&nbsp;&nbsp;</td>" + "<td>" + this.getValue().getValue() + "</td>"
				+ "</tr>" + "</table>");
	}

	public ProductAttribute fromJson(JSONObject attrJson)
	{
		this.m_attribute = attrJson.has("m_attribute") ? new Attribute().fromJson(attrJson.getJSONObject("m_attribute")) : null;
		this.m_value = attrJson.has("m_value") ? new AttributeValue().fromJson(attrJson.getJSONObject("m_value")) : null;
		return this;
	}
}

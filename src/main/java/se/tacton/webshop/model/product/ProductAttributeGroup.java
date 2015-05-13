package se.tacton.webshop.model.product;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import se.tacton.webshop.model.Attribute;

public class ProductAttributeGroup extends ProductAttribute
{
	private List<ProductAttribute> m_attributes = new ArrayList<>();

	public ProductAttributeGroup()
	{
	}

	public ProductAttributeGroup(Attribute inAttribute)
	{
		this.setAttribute(inAttribute);
	}

	public void addProductAttribute(ProductAttribute inAttribute)
	{
		this.m_attributes.add(inAttribute);
	}

	public List<ProductAttribute> getProductAttributes()
	{
		return m_attributes;
	}

	@Override
	public String getHtml()
	{
		StringBuffer str = new StringBuffer();
		for (ProductAttribute anAttr : getProductAttributes())
		{
			str.append(anAttr.getHtml());
		}
		return ("<fieldset>" + "<legend>" + this.getAttribute().getName() + "</legend>" + str.toString() + "</fieldset>");
	}

	public ProductAttribute fromJson(JSONObject attrJson)
	{
		this.m_attribute = attrJson.has("m_attribute") ? new Attribute().fromJson(attrJson.getJSONObject("m_attribute")) : null;

		if (attrJson.has("m_attributes"))
		{
			JSONArray attributes = attrJson.getJSONArray("m_attributes");
			for (int i = 0; i < attributes.length(); i++)
			{
				JSONObject attrJson2 = attributes.getJSONObject(i);
				if (attrJson2.has("m_value"))
				{
					this.m_attributes.add(new ProductAttributeSingle().fromJson(attrJson2));
				}
				if (attrJson2.has("m_attributes"))
				{
					this.m_attributes.add(new ProductAttributeGroup().fromJson(attrJson2));
				}
			}
		}
		return this;
	}
}

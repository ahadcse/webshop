package se.tacton.webshop.model.product;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Product
{
	//Unique user id;
	private String m_id;

	private String m_name;

	private List<ProductAttribute> m_productAttributes = new ArrayList<>();

	public Product()
	{
	}

	public Product(String inId, String inName)
	{
		this.m_id = inId;
		this.m_name = inName;
	}

	public void addProductAttribute(ProductAttribute inProductAttribute)
	{
		this.m_productAttributes.add(inProductAttribute);
	}

	public String getId()
	{
		return m_id;
	}

	public String getName()
	{
		return m_name;
	}

	public List<ProductAttribute> getProductAttributes()
	{
		return m_productAttributes;
	}

	public String getHtml()
	{
		StringBuffer str = new StringBuffer();
		for (ProductAttribute anAttr : getProductAttributes())
		{
			str.append(anAttr.getHtml());
		}
		return ("<h2>" + this.getName() + "</h2>" + "<fieldset>" + "<legend>Product Attributes</legend>" + str.toString() + "</fieldset>");
	}

	public Product fromJson(JSONObject productJson)
	{
		this.m_id = productJson.has("m_id") ? productJson.getString("m_id") : "";
		this.m_name = productJson.has("m_name") ? productJson.getString("m_name") : "";

		if (productJson.has("m_productAttributes"))
		{
			JSONArray attributes = productJson.getJSONArray("m_productAttributes");
			for (int i = 0; i < attributes.length(); i++)
			{
				JSONObject attrJson = attributes.getJSONObject(i);
				if (attrJson.has("m_value"))
				{
					this.m_productAttributes.add(new ProductAttributeSingle().fromJson(attrJson));
				}
				if (attrJson.has("m_attributes"))
				{
					this.m_productAttributes.add(new ProductAttributeGroup().fromJson(attrJson));
				}
			}
		}

		return this;
	}
}

package se.tacton.webshop.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import se.tacton.webshop.model.product.Product;

public class Cart
{
    private String m_id;
    
    private String m_customerId;
    
    private List<Product> m_products = new ArrayList<>();
    
    public Cart() {
    }
    
    public Cart(String inId, String inCustomerId, List<Product> inProducts)
    {
        this.m_id = inId;
        this.m_customerId = inCustomerId;
        this.m_products = inProducts;
    }
    
    public String getId()
    {
        return m_id;
    }
    
    public String getCustomerId()
    {
        return m_customerId;
    }
    
    public List<Product> getProducts()
    {
        return m_products;
    }
    
    public Cart fromJson(JSONObject cartJson) {
        this.m_id = cartJson.has("m_id") ? cartJson.getString("m_id") : "";
        this.m_customerId = cartJson.has("m_customerId") ? cartJson.getString("m_customerId") : "";
        if (cartJson.has("m_products")) {
            JSONArray products = cartJson.getJSONArray("m_products");
            for (int i = 0; i < products.length(); i++) {
                this.m_products.add(new Product().fromJson(products.getJSONObject(i)));
            }
        }
        
        return this;
    }
    
}

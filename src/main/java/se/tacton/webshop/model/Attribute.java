package se.tacton.webshop.model;

import org.json.JSONObject;

public class Attribute {
    private String m_name;
    
    public Attribute() {
    }
    
    public Attribute(String inName) {
        m_name = inName;
    }
    
    public String getName()
    {
        return m_name;
    }

    public Attribute fromJson(JSONObject attrJson) {
        this.m_name = attrJson.has("m_name") ? attrJson.getString("m_name") : "";
        return this;
    }
}

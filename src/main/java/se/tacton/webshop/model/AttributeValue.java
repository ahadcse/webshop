package se.tacton.webshop.model;

import org.json.JSONObject;

public class AttributeValue {
    private String m_value;
    
    public AttributeValue() {
    }
    
    public AttributeValue(String inValue) {
        m_value = inValue;
    }
    
    public String getValue()
    {
        return m_value;
    }

    public AttributeValue fromJson(JSONObject attrJson) {
        this.m_value = attrJson.has("m_value") ? attrJson.getString("m_value") : "";
        return this;
    }
}

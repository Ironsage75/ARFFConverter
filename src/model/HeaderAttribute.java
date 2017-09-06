package model;

/**
 * Created by amy on 5/09/2017.
 */
public class HeaderAttribute {
    String attributeName = null;
    String attributeType = null;

    public HeaderAttribute(String attributeName, String attributeType) {
        this.attributeType = attributeType;
        this.attributeName = attributeName;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}

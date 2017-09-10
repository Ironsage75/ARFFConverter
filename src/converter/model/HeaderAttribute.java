package converter.model;

/**
 * Java object used to store information concerning the Attributes,
 * Contains the attribute's name and its type (numeric, string, class, date).
 * Created by amy on 5/09/2017.
 */
public class HeaderAttribute {
    private String attributeName = null;
    private String attributeType = null;

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

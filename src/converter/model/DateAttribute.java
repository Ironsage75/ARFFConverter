package converter.model;

/**
 * Java object to store Class attribute information
 * Extends from HeaderAttribute, but has the option to add a dateformat String
 * Created by amy on 5/09/2017.
 */
public class DateAttribute extends HeaderAttribute {
    private String dateFormat;

    public DateAttribute(String attributeName, String attributeType) {
        super(attributeName, attributeType);
    }

    public DateAttribute(String attributeName, String attributeType, String dateFormat) {
        super(attributeName, attributeType);
        this.dateFormat = dateFormat;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}

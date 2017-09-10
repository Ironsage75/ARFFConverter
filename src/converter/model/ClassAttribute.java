package converter.model;

/**
 * Java object to store Class attribute information
 * Extends from HeaderAttribute, but adds a list of Strings containing the different classes
 * Created by amy on 5/09/2017.
 */
public class ClassAttribute extends HeaderAttribute {
    private String[] classes;

    public ClassAttribute(String attributeName, String attributeType, String[] classes) {
        super(attributeName, attributeType);
        this.classes = classes;
    }

    public String[] getClasses() {
        return classes;
    }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }

}

package model;

import java.util.ArrayList;

/**
 * Created by amy on 5/09/2017.
 */
public class ClassAttribute extends HeaderAttribute {
    String[] classes;

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

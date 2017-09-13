package converter;

import converter.model.ClassAttribute;
import converter.model.DateAttribute;
import converter.model.HeaderAttribute;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Converts the input read in from command line to a HeaderAttribute or an ArrayList of HeaderAttributes
 * Created by amy on 5/09/2017.
 */
public class HeaderReader {

    public HeaderReader() {
    }

    /**
     * Converts an arraylist of string inputs to an arraylist of headerattributes
     *
     * @param lines Arraylist of Strings containing the headernames and types, read in from commandline,
     *              a single line written as AttributeName AttributeType
     * @return Arraylist of HeaderAttribute objects with their respective information
     */
    public ArrayList<HeaderAttribute> readAttributeList(ArrayList<String> lines) {
        ArrayList<HeaderAttribute> headers = new ArrayList<>();
        for (String line : lines) {
            if (!line.isEmpty()) {
                //splits the string up at the space (indicated as how the user should input the information), into name and type
                String[] split = line.split("--");
                /**
                 * Check if the attribute is of type "date" in which case the user has the option to input a specific dateformat
                 * This gets saved as a DateAttribute, which extends from HeaderAttribute
                 */
                if (split[1].equalsIgnoreCase("date")) {
                    DateAttribute attribute = null;
                    System.out.println("Enter dateformat for " + split[0] + ", if required, otherwise press enter:");
                    Scanner scanner = new Scanner(System.in);
                    if (!scanner.nextLine().isEmpty()) {
                        String format = scanner.nextLine();
                        attribute = new DateAttribute(split[0], split[1], format);
                    } else {
                        attribute = new DateAttribute(split[0], split[1]);
                    }
                    headers.add(attribute);
                }
                /**
                 * Check if the attribute is of type "class", in which case the user has to input the different classes
                 * This gets saved as a ClassAttribute, which extends from HeaderAttribute
                 */
                else if (split[1].equalsIgnoreCase("class")) {
                    ClassAttribute attribute = null;
                    System.out.println("Enter classnames for " + split[0] + ", seperated by commas:");
                    Scanner scanner2 = new Scanner(System.in);
                    String classes = scanner2.nextLine();
                    String[] splitClasses = classes.split(",");
                    attribute = new ClassAttribute(split[0], split[1], splitClasses);
                    headers.add(attribute);
                } else {
                    headers.add(new HeaderAttribute(split[0], split[1]));
                }
            }
        }
        return headers;
    }

    /**
     * Converts a single string input to a HeaderAttribute Object
     *
     * @param line The String line read from command line, written as AttributeName AttributeType
     * @return A single HeaderAttribute object
     */
    public HeaderAttribute readAttribute(String line) {
        String header = null;
        String[] split = line.split("\\s+");
        if (split[1].equalsIgnoreCase("date")) {
            DateAttribute attribute = new DateAttribute(split[0], split[1]);
            System.out.println("Enter dateformat for " + split[0] + ", if required, otherwise press enter:");
            Scanner scanner = new Scanner(System.in);
            if (!scanner.nextLine().isEmpty()) {
                String format = scanner.nextLine();
                attribute.setDateFormat(format);
            }
            scanner.close();
            return attribute;
        } else if (split[1].equalsIgnoreCase("class")) {
            ClassAttribute attribute = null;
            System.out.println("Enter classnames for " + split[0] + ", seperated by commas (no spaces):");
            Scanner scanner = new Scanner(System.in);
            String classes = scanner.nextLine();
            String[] splitClasses = classes.split(",");
            attribute = new ClassAttribute(split[0], split[1], splitClasses);
            scanner.close();
            return attribute;
        } else {
            return new HeaderAttribute(split[0], split[1]);
        }
    }
}

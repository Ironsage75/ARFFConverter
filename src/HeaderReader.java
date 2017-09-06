import model.ClassAttribute;
import model.DateAttribute;
import model.HeaderAttribute;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by amy on 5/09/2017.
 */
public class HeaderReader {

    public HeaderReader() {
    }

    public ArrayList<HeaderAttribute> read(ArrayList<String> lines){
        ArrayList<HeaderAttribute> headers = new ArrayList<>();
        for (String line : lines){
                String[] split = line.split("\\s+");
                if(split[1].equalsIgnoreCase("date")){
                    DateAttribute attribute = new DateAttribute(split[0], split[1]);
                    System.out.println("Enter dateformat if required, otherwise press enter:");
                    Scanner scanner = new Scanner(System.in);
                    if (!scanner.nextLine().isEmpty()) {
                        String format = scanner.nextLine();
                        attribute.setDateFormat(format);
                    }
                    headers.add(attribute);
                    scanner.close();
                } else if(split[1].equalsIgnoreCase("class")){
                    ClassAttribute attribute = null;
                    System.out.println("Enter classnames for " + split[0] + ", seperated by commas (no spaces):");
                    Scanner scanner = new Scanner(System.in);
                    String classes = scanner.nextLine();
                    String[] splitClasses = classes.split(",");
                    attribute = new ClassAttribute(split[0], split[1], splitClasses);
                    headers.add(attribute);
                    scanner.close();
                } else{
                    headers.add(new HeaderAttribute(split[0], split[1]));
                }
            }
        return headers;
    }
}

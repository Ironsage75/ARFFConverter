import converter.ARFFConverter;
import converter.HeaderReader;
import converter.model.HeaderAttribute;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ARFFConverter converter = new ARFFConverter();
        HeaderReader reader = new HeaderReader();
        ArrayList<HeaderAttribute> headers = null;
        ArrayList<String> lines = new ArrayList<>();
        String filepath = null;
        Scanner scanner = new Scanner(System.in);

        /**
         * Read in the filepath for the file that should be converted
         */
        System.out.println("Input filepath:");
        filepath = scanner.nextLine();

        /**
         * Input attribute information to be added to the header of the ARFF file
         */
        System.out.println("\nInput header names and type in the format 'headername[space]type', where type is [numeric, string, date, class] (type 'stop' when you are done):");
        scanner = scanner.reset();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equalsIgnoreCase("stop")) {
                lines.add(line);
            } else {
                break;
            }
        }

        headers = reader.readAttributeList(lines);
        converter.convert(filepath,headers);
}
}

import model.ClassAttribute;
import model.DateAttribute;
import model.HeaderAttribute;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ARFFConverter converter = new ARFFConverter();
        HeaderReader reader = new HeaderReader();
        ArrayList<HeaderAttribute> headers = null;
        ArrayList<String> lines = new ArrayList<>();
        String filepath = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input filepath:");
        filepath = scanner.nextLine();

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

        headers = reader.read(lines);
        converter.convert(filepath,headers);
}
}

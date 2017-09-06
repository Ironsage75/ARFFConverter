import model.ClassAttribute;
import model.DateAttribute;
import model.HeaderAttribute;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String filepath = null;
        ARFFConverter converter = new ARFFConverter();
        ArrayList<HeaderAttribute> headers = null;
        ArrayList<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        HeaderReader reader = new HeaderReader();

        System.out.println("Input filepath:");
        filepath = scanner.nextLine();
        System.out.println(filepath);

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

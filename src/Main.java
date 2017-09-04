import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String filepath = null;
        ArrayList<String> headers = new ArrayList<>();
        ArrayList<String> headertypes = new ArrayList<>();
        ARFFConverter converter = new ARFFConverter();
        System.out.println("Input filepath:");
        Scanner scanner = new Scanner(System.in);
        filepath = scanner.nextLine();
        System.out.println("\nInput header names (press enter again after last one):");
        while (scanner.hasNextLine()){
            if (!scanner.nextLine().isEmpty()) {
                headers.add(scanner.nextLine());
            } else {
                break;
            }
        }
        System.out.println("\nInput header types: numeric, string, date or class (press enter again after last one)");
        while (scanner.hasNextLine()){
            if (!scanner.nextLine().isEmpty()) {
                if(scanner.nextLine().equalsIgnoreCase("date")) {
                    String temp = scanner.nextLine();
                    System.out.println("Enter dateformat if required, otherwise press enter:");
                    if (scanner.nextLine().isEmpty()) {
                       headertypes.add(temp);
                    } else{
                        String format = scanner.nextLine();
                        headertypes.add(temp + "[" + format + "]");
                    }
                } else if (scanner.nextLine().equalsIgnoreCase("class")){
                    String temp = scanner.nextLine();
                    System.out.println("Enter classnames seperated by commas:");
                    String classes = scanner.nextLine();
                    headertypes.add(temp + "{" + classes + "}");
                } else {
                    headertypes.add(scanner.nextLine());
                }
            } else {
                break;
            }
        }
        converter.convert(filepath, headers);
    }
}


package common;

import java.io.File;
import java.util.Scanner;


public class Library {
    private Scanner sc = new Scanner(System.in);
    public final String COMMA_DELIMITER = ",";
    public final String NEW_LINE_SEPARATOR = "\n";
    public int inputIntLimit(int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                
            }
        }
    }
    public String checkInputPathFile(String promt) {
        System.out.print(promt);
        while (true) {
            String result = sc.nextLine().trim();
            File file = new File(result);
            if (!file.exists() || !file.isDirectory()) {
                System.err.println("Path doesn't exist or is not a valid directory!!!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    public String getString(String promt) {
        String s;
        do {
            System.out.print(promt);
            s = sc.nextLine();
        } while (s.equalsIgnoreCase(""));
        return s;
    }
}

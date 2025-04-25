package Game;

import java.util.Scanner;

public class ErrorCheck{
    public static int getInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("That's not a number! Please enter a number:");
            sc.next(); 
        }
        return sc.nextInt();
    }
}

/* Michael Benful, Peter Benson, Ahaan Chabba 12/19/2024

*/
package Quiz;
import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }

    Category ask(Scanner sc) {
        System.out.println(this.label);
        
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }

        int ans = -1; 
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a number (1-4): ");
            if (sc.hasNextInt()) {
                ans = sc.nextInt();
                if (ans >= 1 && ans <= 4) {
                    validInput = true; 
                } else {
                    System.out.println("Invalid input! Please choose a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number!");
                sc.next(); 
            }
        }

        return possibleAnswers[ans - 1].cat;
    }
}
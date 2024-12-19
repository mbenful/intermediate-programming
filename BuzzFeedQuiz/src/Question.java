/* Michael Benful, Peter Benson, Ahaan Chabba 12/19/2024
A question class with Answers.
*/ 
import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category that corresponds to the answer
    Category ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }

        int ans = sc.nextInt();
        while (ans < 1 || ans > 4) {
            System.out.print("Enter a number (1-4): ");
            if (sc.hasNextInt()) {
                ans = sc.nextInt();
                if (ans < 1 || ans > 4) {
                    System.out.println("Invalid input!!! Please choose a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Enter a number!");
                sc.next();
            }
        }
        return possibleAnswers[ans - 1].cat;
    }

}

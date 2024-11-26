import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    
    System.out.println("Guess the number I am thinking about between 1 and 100.");
    Random random = new Random();
   int a = 5;
    int number = random.nextInt(100) + 1;
    Scanner sc = new Scanner(System.in);

ArrayList<Integer> pastGuess = new ArrayList<>();
    //make it a while loop
    while (true) {
        while ( a > 0) {
            System.out.println("You have " + a + " attempts");
    if (sc.hasNextInt()) {
        int guess = sc.nextInt();
        
        if (pastGuess.contains(guess)) {
            System.out.println("You already guessed " + guess + "! Try again");
            continue;
        }

        pastGuess.add(guess);
        if ( checkInt(guess, number)){
            return;
        }
        a--;

    } 
   else {
        String bad = sc.next();
        System.out.println(bad + " is a bad input! Try again");
    }
    if(a==0) {
        System.out.println("SORRY, you ran out of guesses! GAME OVER!");
        return;
    }
    }
}
}

static boolean checkInt(int guess, int number)  {
    if (guess == number){
        System.out.println("Correct!!");
        return true;
          }
        else if (guess > number){
        System.out.println("lower");
             }
             else if (guess < number){
                 System.out.println("higher");
                     }
        return false;

                    }
}



import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    
   
    System.out.println("Guess the number I am thinking about between 1 and 100.");
    Random random = new Random();
   int a = 5;
    int number = random.nextInt(100);
    Scanner sc = new Scanner(System.in);

    
    //make it a while loop
    while (true) {
        while ( a>=0) {
            System.out.println("You have " + a + " attempts");
    if (sc.hasNextInt()) {
        int guess = sc.nextInt();
        checkInt(guess, number);
        a = a-1;

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

    /*if (sc.hasNextInt()) {
        int guess = sc.nextInt();
        checkInt(guess, number);
    } else {
        String bad = sc.next();
        System.out.println("bad input! " + bad);
    }
    } */
static int checkInt(int guess, int number)  {
    if (guess == number){
        System.out.println("Correct!!");
          }
        else if (guess > number){
        System.out.println("lower");
             }
             else if (guess < number){
                 System.out.println("higher");
                     }
        return guess;

                    }
}



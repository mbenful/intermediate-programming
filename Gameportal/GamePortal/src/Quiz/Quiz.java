/*
 * Michael, Peter, Ahaan Chabba
 * This is the class where we create the Quiz and run it. It has the main method.  We all equally worked on this.
 */
package Quiz;
import java.io.File;
import java.util.Scanner;

import Game.Game;

public class Quiz implements Game {
        static Scanner sc = new Scanner(System.in);
        private static String desc;
        
    
        public static void main(String[] args) throws Exception {
                // Create Categories
                Category Tennis = new Category("Tennis", "You like Tennis.");
                Category Base = new Category("Baseball", "You like Baseball");
                Category Basket= new Category("Basketball", "You like Basketball");
                Category Soccer = new Category("Soccer", "You like Soccer.");
                // Create Questions
                Question q1 = new Question("What is your favorite Brand?");
                // Attach Answers to Questions
                q1.possibleAnswers[0] = new Answer("Adidas", Soccer);
                q1.possibleAnswers[1] = new Answer("Under Armour",
                                Base);
                q1.possibleAnswers[2] = new Answer("Nike", Basket);
                q1.possibleAnswers[3] = new Answer("Polo", Tennis);

                Question q2 = new Question("What is your favorite pre-game snack?");
                q2.possibleAnswers[0] = new Answer("Granola", Tennis);
                q2.possibleAnswers[1] = new Answer("Sunflower Seeds", Base);
                q2.possibleAnswers[2] = new Answer("PB&J", Basket);
                q2.possibleAnswers[3] = new Answer("Plantain",
                                Soccer);

                // ... more questions here
                Question q3 = new Question("Favorite Celebration?");
                q3.possibleAnswers[0] = new Answer("Hang up the telephone", Tennis);
                q3.possibleAnswers[1] = new Answer("Drop the mic", Base);
                q3.possibleAnswers[2] = new Answer("Ice in veins", Basket);
                q3.possibleAnswers[3] = new Answer("Sui", Soccer);


                Question q4 = new Question("What is your favorite city to travel to?");
                q4.possibleAnswers[0] = new Answer("London", Soccer);
                q4.possibleAnswers[1] = new Answer("New York", Base);
                q4.possibleAnswers[2] = new Answer("L.A", Basket);
                q4.possibleAnswers[3] = new Answer("Madrid", Tennis);

                Question q5 = new Question("What is your favorite car?");
                q5.possibleAnswers[0] = new Answer("Porsche", Tennis);
                q5.possibleAnswers[1] = new Answer("Dodge", Base);
                q5.possibleAnswers[2] = new Answer("Rolls Royce", Basket);
                q5.possibleAnswers[3] = new Answer("Lambo",
                                Soccer);

                Question q6 = new Question("What is your favorite color?");
                q6.possibleAnswers[0] = new Answer("Green", Tennis);
                q6.possibleAnswers[1] = new Answer("Orange", Base);
                q6.possibleAnswers[2] = new Answer("Red", Basket);
                q6.possibleAnswers[3] = new Answer("Blue",
                                Soccer);

                Question q7 = new Question("What is your favorite Competition?");
                q7.possibleAnswers[0] = new Answer("1 V 1", Tennis);
                q7.possibleAnswers[1] = new Answer("Strength Contest", Base);
                q7.possibleAnswers[2] = new Answer("Small-Group Victory", Basket);
                q7.possibleAnswers[3] = new Answer("Big-Group Victory",
                                Soccer);

                Question q8 = new Question("What is your favorite part of playing a game?");
                q8.possibleAnswers[0] = new Answer("Having fun with others", Basket);
                q8.possibleAnswers[1] = new Answer("Seeing how well you do", Soccer);
                q8.possibleAnswers[2] = new Answer("Winning", Tennis);
                q8.possibleAnswers[3] = new Answer("Cheering other on",
                                Base);


                gameIntro();
                Question[] qList = { q1, q2 ,q3, q4, q5, q6, q7, q8};
                for (Question q : qList) {
                        Category c = q.ask(sc);
                        c.points++;
                }
                
                Category[] cList = { Base, Basket, Tennis, Soccer };
                
                int index = getMostPopularCatIndex(cList);
        desc = cList[index].description;
        System.out.println("If you were a sport, you would be " + cList[index].description + ". ");
                System.out.println(cList[index].description);

        }

        public static void gameIntro() {
    
                System.out.println("What sport are you, Buzzfeed Quiz");
                System.out.println("You must choose numbers 1-4 for every question. Enter '1' to play!");
            
                boolean validInput = false;
            
                while (!validInput) {
                    System.out.print("Enter a number: ");
            
                    if (sc.hasNextInt()) {
                        int play = sc.nextInt();
                        if (play == 1) {
                            validInput = true;
                            System.out.println("Let's play!");
                        } else {
                            System.out.println("Unidentifiable input. Please enter '1' to play.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number!");
                        sc.next();
                    }
                }
            }


        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }


    @Override
    public String getGameName() {
        return "Buzzfeed Quiz";
    }

    @Override
    public void play() {
        gameIntro();
    }

    @Override
    public String getScore() {
        return (desc);
    }

    @Override
    public void writeHighScore(File f) {
        System.out.println("Buzzfeed Sport saved");
    }
}

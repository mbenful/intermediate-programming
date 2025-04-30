import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Game.ErrorCheck;
import Game.Game;
import Quiz.Quiz;
import Store.SuperStore;

public class GamePortal {
    static Scanner sc = new Scanner(System.in);
  public  static String currentUser;
    static ArrayList<Game> games = new ArrayList<Game>();
    static File scoreFile = new File("scores.csv");

    public static void main(String[] args) {

        System.out.print("Welcome, please enter your username: ");
        currentUser = sc.nextLine();

        while (true) {
            loadGames();
            System.out.println("Hello " + currentUser + " Which game would you like to play?");
            printGameChoices();

            Game g = getGameChoice();
            System.out.println("You're playing " + g.getGameName());
            g.play();

            g.writeHighScore(scoreFile);
            displayScores();
        }
    }

    private static void displayScores() {
        try (Scanner sc = new Scanner(scoreFile)) {
            System.out.println("Current Leaderboard");
            System.out.println("USER, Game, Score");
            while (sc.hasNextLine()) {
                String[] entry = sc.nextLine().split(",");
                System.out.println(entry[0] + ": " + entry[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No scores recorded yet.");
        }
    }

    public static void loadGames() {
        games.clear();
        games.add(new NumberGuessGame());
        games.add(new SuperStore());
        games.add(new Quiz());
    }

    public static void printGameChoices() {
        int n = 1;
        for (Game s : games) {
            System.out.println("[" + (n++) + "]: " + s.getGameName());
        }
    }

    public static Game getGameChoice() {
        int choice = ErrorCheck.getInt(sc);
        // for it to be numbered, we can't use hashmaps.
        while (choice < 1 || choice > games.size()) {
            System.out.println("We don't have this number. Try again.");
            choice = ErrorCheck.getInt(sc);
        }

        // valid game choice
        return games.get(choice - 1);
    }
}
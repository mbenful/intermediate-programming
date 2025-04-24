// Copyright 2025 Michael Benful
package Quiz;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> userScores = new HashMap<>();
        int highscore = Integer.MAX_VALUE;
        String username = "";

        Scanner sc = new Scanner(System.in);
        FileSave fileSave = new FileSave("scores.csv");
        userScores = fileSave.getResults();

        for (int i = 1; i < 4; i++) {
            System.out.println("Please enter desired username:");
            username = sc.nextLine();

            Quiz whatever = new Quiz();
            whatever.playGame();
            int currentScoreInt = whatever.getScore();
            String currentScore = Integer.toString(currentScoreInt);

            userScores.put(username, currentScore);

            if (whatever.getScore() < highscore) {
                highscore = currentScoreInt;
                System.out.println("new highscore is " + highscore);
            }
            whatever.getScore();
            System.out.println("Best highscore is " + highscore);
            System.out.println("New Game:");
        }
        System.out.println("Leaderboard:");
        for (Map.Entry<String, String> entry : userScores.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

        fileSave.updateResult(username, userScores.get(username));
    }
}
// Copyright 2025 Michael Benful
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Game.GameWriteable;

public class NumberGuessGame implements GameWriteable {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> pastGuesses = new ArrayList<>();
    public String username;

    @Override
    public String getGameName() {
        return "Number Guess Game";
    }

    @Override
    public void play() {
        playGame();
    }

    public void playGame() {
        pastGuesses.clear();
        int lowerNum = 0, upperNum = 0;
        
        while (true) {
            System.out.println("Enter the lower number of the range: ");
            if (sc.hasNextInt()) {
                lowerNum = sc.nextInt();
                System.out.println("Enter the upper number of the range: ");
                if (sc.hasNextInt()) {
                    upperNum = sc.nextInt();
                    if (lowerNum >= upperNum) {
                        System.out.println("Invalid range! Lower number must be less than the upper number. Try again.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println(sc.next() + " is not a valid number. Try again.");
                }
            } else {
                System.out.println(sc.next() + " is not a valid number. Try again.");
            }
        }

        Random random = new Random();
        int number = random.nextInt(upperNum - lowerNum + 1) + lowerNum;
        System.out.println("I have picked a number between " + lowerNum + " and " + upperNum + ". Try to guess it!");

        while (true) {
            System.out.println("Enter your guess: ");
            if (sc.hasNextInt()) {
                int guess = sc.nextInt();

                if (pastGuesses.contains(guess)) {
                    System.out.println("You already guessed " + guess + "! Try again.");
                    continue;
                }

                pastGuesses.add(guess);

                if (checkGuess(guess, number)) {
                    System.out.println("Congrats! You guessed the number in " + pastGuesses.size() + " attempts.");
                    break;
                }
            } else {
                System.out.println(sc.next() + " is not a valid number, try again");
            }
        }
    }

    @Override
    public String getScore() {
        return Integer.toString(pastGuesses.size());
    }

    @Override
    public boolean isHighScore(String score, String currentHighScore) {
        if (currentHighScore == null) return true;
        try {
            int current = Integer.parseInt(score);
            int high = Integer.parseInt(currentHighScore);
            return current < high;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void writeHighScore(File f) {
        GameWriteable.super.writeHighScore(f);
    }

    static boolean checkGuess(int guess, int number) {
        if (guess == number) {
            return true;
        } else if (guess > number) {
            System.out.println("Lower");
        } else {
            System.out.println("Higher");
        }
        return false;
    }
}
// Created by Armin Asl and Michael Benful
// Enjoy!
package Store;
import java.io.File;
import java.util.ArrayList;

import Game.Game;
import processing.core.PApplet;

public class SuperStore extends PApplet implements Game{
    Store store;
    Player player;
    Button[] aircraftButtons;
    ArrayList<FlightButtonSet> flightButtonSets;
    Aircraft selectedAircraft;
    Button endGameButton;
    boolean gameEnded = false;

    public void settings() {
        size(900, 600);
    }

    public void setup() {
        store = new Store();
        player = new Player(500000000000l); // Start with $500M
        store.initializeItems();
        initializeAircraftButtons();
        initializeFlightButtons();
        endGameButton = new Button(50, 550, 200, 40, "End Game", this);
    }

    void initializeAircraftButtons() {
        aircraftButtons = new Button[store.aircraftList.size()];
        int y = 120;
        for (int i = 0; i < store.aircraftList.size(); i++) {
            Aircraft aircraft = store.aircraftList.get(i);
            aircraftButtons[i] = new Button(50, y, 700, 40, aircraft.getName() + " - $" + aircraft.getPrice(), this);
            y += 50;
        }
    }

    void initializeFlightButtons() {
        flightButtonSets = new ArrayList<>();
        int y = 300;
        for (Destination destination : store.destinations) {
            flightButtonSets.add(new FlightButtonSet(this, destination, 50, y));
            y += 50;
        }
    }

    public void draw() {
        drawSkyBackground(); // New method for sky effect
    
        if (gameEnded) {
            displayEndScreen();
        } else {
            displayGameInfo();
            drawButtons();
        }
    }

    void drawSkyBackground() {
        for (int i = 0; i < height; i++) {
            float lerpFactor = map(i, 0, height, 0, 1);
            int skyColor = lerpColor(color(135, 206, 250), color(0, 102, 204), lerpFactor); // Light blue to deep blue gradient
            stroke(skyColor);
            line(0, i, width, i);
        }
    }    


    void displayGameInfo() {
        fill(0);
        textSize(24);
        textAlign(LEFT, TOP);
        text("Private Jet Travel!", 50, 30);
        textSize(18);
        text("Your Balance: $" + player.getBalance(), 50, 70);
        text("Total Emissions: " + player.getTotalEmissions() + " tons", 50, 90);

        if (player.hasDestroyedTheWorld()) {
            textSize(30);
            fill(255, 0, 0);
            text("Game Over: You've Destroyed the World!", 50, 500);
        }
    }

    void drawButtons() {
        for (Button button : aircraftButtons) {
            button.display();
        }
        for (FlightButtonSet buttonSet : flightButtonSets) {
            buttonSet.display();
        }
        endGameButton.display();
    }

    void displayEndScreen() {
        background(50);
        fill(255);
        textSize(32);
        textAlign(CENTER, CENTER);
        text("Game Over!", width / 2, 100);
        
        textSize(24);
        text("Total CO₂ Emissions: " + player.getTotalEmissions() + " tons", width / 2, 200);
    
        // Get impact message and format it for wrapping
        String impactMessage = getImpactMessage(player.getTotalEmissions());
    
        // Display the message with proper wrapping
        textSize(20);
        textAlign(CENTER, CENTER);
        float messageX = width / 2;
        float messageY = 350;
        float maxWidth = width * 0.8f; // 80% of screen width for better readability
        displayWrappedText(impactMessage, messageX, messageY, maxWidth);
    }

    void displayWrappedText(String text, float x, float y, float maxWidth) {
        String[] words = text.split(" ");
        String line = "";
        float lineHeight = 30; // Adjust line spacing
    
        for (String word : words) {
            String testLine = line + word + " ";
            float textWidth = textWidth(testLine);
    
            if (textWidth > maxWidth) {
                text(line, x, y);
                line = word + " ";
                y += lineHeight; // Move to next line
            } else {
                line = testLine;
            }
        }
        text(line, x, y); // Print last line
    }   

    String getImpactMessage(double emissions) {
        if (emissions < 10_000) {
            return "You've emitted a small amount. The world still survives, but you've contributed to warming.";
        } else if (emissions < 100_000_000) {
            return "Your emissions have accelerated climate change. The ice caps are melting faster!";
        } else if (emissions < 1_000_000_000) {
            return "You've pushed global warming beyond safe levels! Severe climate disasters are happening!";
        } else {
            return "Congratulations! You have single-handedly destroyed the world.";
        }
    }

    public void mousePressed() {
        if (gameEnded) return; // Stop interaction if the game has ended
    
        if (endGameButton.isMouseOver()) {
            gameEnded = true;
            return;
        }
    
        // Handle Aircraft Selection and Purchase
        for (int i = 0; i < aircraftButtons.length; i++) {
            if (aircraftButtons[i].isMouseOver()) {
                Aircraft aircraft = store.aircraftList.get(i);
                
                // Only allow purchase if the player has enough money
                if (player.deductBalance(aircraft.getPrice())) {
                    selectedAircraft = aircraft;
                    System.out.println("Purchased and selected: " + aircraft.getName());
                } else {
                    System.out.println("Not enough money to buy " + aircraft.getName());
                }
            }
        }
    
        // Handle Flight Selections
        for (FlightButtonSet buttonSet : flightButtonSets) {
            buttonSet.handleClick();
        }
    }
    

    public static void main(String[] args) {
        PApplet.main("SuperStore");
    }

    @Override
    public String getGameName() {
        return "Super Store";
    }

    @Override
    public void play() {
        String[] args = {"SuperStore"};
        PApplet.runSketch(args, this);
    }

    @Override
    public String getScore() {
        return String.valueOf(player.getTotalEmissions());
    }

    @Override
    public void writeHighScore(File f) {
        System.out.println("Super Store score saved");
    }
}

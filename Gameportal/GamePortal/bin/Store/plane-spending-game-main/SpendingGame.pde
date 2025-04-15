import processing.core.*;

public class SuperStore extends PApplet {
    Store store;
    Player player;

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        store = new Store();
        player = new Player(1000000000); // Player starts with 1 billion dollars
        store.initializeItems();
    }

    public void draw() {
        background(255);
        displayStore();
    }

    void displayStore() {
        fill(0);
        textSize(20);
        text("Welcome to SuperStore!", 50, 50);
        text("Your Balance: $" + player.getBalance(), 50, 80);

        int y = 120;
        for (int i = 0; i < store.items.size(); i++) {
            Item item = store.items.get(i);
            text((i + 1) + ". " + item.getName() + " - $" + item.getPrice(), 50, y);
            y += 30;
        }

        text("Press 1-" + store.items.size() + " to buy an item", 50, height - 50);
    }

    public void keyPressed() {
        int choice = key - '0' - 1;
        if (choice >= 0 && choice < store.items.size()) {
            Item item = store.items.get(choice);
            if (player.purchaseItem(item)) {
                println("You bought: " + item.getName());
            } else {
                println("Not enough balance!");
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("SuperStore");
    }
}

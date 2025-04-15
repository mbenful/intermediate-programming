// Created by Armin Asl and Michael Benful
// Enjoy!

import java.util.ArrayList;

public class Store {
    ArrayList<Aircraft> aircraftList;
    ArrayList<Destination> destinations;

    public Store() {
        aircraftList = new ArrayList<>();
        destinations = new ArrayList<>();
    }

    public void initializeItems() {
        // Adding aircraft
        aircraftList.add(new Aircraft("Boeing 767", 185000000, 0.025)); // 0.025 tons per mile
        aircraftList.add(new Aircraft("Boeing 787", 240000000, 0.018)); // 0.018 tons per mile

        // Adding destinations (from NYC) with cost per mile
        destinations.add(new Destination("London", 3450, 20));  // $20 per mile
        destinations.add(new Destination("Paris", 3620, 21));   // $21 per mile
        destinations.add(new Destination("Tokyo", 6730, 25));   // $25 per mile
        destinations.add(new Destination("Dubai", 6830, 24));   // $24 per mile
        destinations.add(new Destination("Sydney", 9930, 30));  // $30 per mile
    }
}

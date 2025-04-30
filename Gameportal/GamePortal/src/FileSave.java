// Copyright 2025 Michael Benful
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FileSave {
    String filename = "scores.csv";
    HashMap<String, String> results = new HashMap();


    FileSave(String filename) throws IOException {
        this.filename = filename;
        loadResults();
    }

    FileSave() throws IOException {
        loadResults();
    }

    public HashMap<String, String> getResults() {
        return results;
    }

    private void loadResults() throws IOException {
        Scanner reader;
        try {
            reader = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating new file.");
            FileWriter fileWriter = new FileWriter(filename);
            reader = new Scanner(new File(filename));
            fileWriter.close();
        }
        reader.useDelimiter(",");
        String line = "";
        while (reader.hasNextLine())
        {
            line = reader.nextLine();
            String[] person = line.split(","); // use comma as separator
            // loads results as name: category
            results.put(person[0], person[1]);
        }
    }

    
    public void updateResult(String key, String value) throws Exception {
        
if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value cannot be null");
        }
        results.put(key, value);
        writeResults();
    }

    // write results the hashmap to filename
    private void writeResults() throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        for (String name : results.keySet()) {
            fileWriter.write(name + "," + results.get(name) + "\n");
        }
        fileWriter.close();
    }
}

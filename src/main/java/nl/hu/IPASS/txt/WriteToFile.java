package nl.hu.IPASS.txt;

import nl.hu.IPASS.model.Uren;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("factuur.txt");
            Uren.createUren(12, "dit gedaan", Uren.getDatum());
            myWriter.write(Uren.getAlleUren().toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

package org.Control3;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Task3 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/Control3/3_input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.sort(Comparator.comparingInt(String::length));

        System.out.println("Sorted lines by length: " + lines);
    }
}

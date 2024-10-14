package org.Control3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Task4 {
    public static void main(String[] args) {
        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/Control3/4_input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        uniqueWords.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Unique words: " + uniqueWords);
    }
}

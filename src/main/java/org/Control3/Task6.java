package org.Control3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) {
        Map<String, Integer> nameCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/Control3/6_Surnames.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String name = line.split(" ")[0];
                nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(nameCount.entrySet());
        sortedNames.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedNames) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
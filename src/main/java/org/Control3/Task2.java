package org.Control3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2{
    public static void main(String[] args) {
        List<Integer> C1 = new ArrayList<>();
        List<Integer> C2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/Control3/2_input.txt"))) {
            String line;
            boolean secondList = false;

            while ((line = br.readLine()) != null) {
                for(String n : line.split(" ")) {
                    int number = Integer.parseInt(n.trim());

                    if (number < 0) {
                        secondList = true;
                        continue;
                    }

                    if (!secondList) {
                        C1.add(number);
                    } else {
                        C2.add(number);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(C1);
        Collections.sort(C2);

        List<Integer> combinedList = new ArrayList<>(C1);
        combinedList.addAll(C2);

        Collections.sort(combinedList);

        System.out.println("C1: " + C1);
        System.out.println("C2: " + C2);
        System.out.println("Combined List: " + combinedList);
    }
}

package org.Control3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Task1 {
    public static void main(String[] args) {
        int X;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/Control3/1_input.txt"))) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            LinkedList<Integer> numbersList = new LinkedList<>();
            for (String part : parts) {
                numbersList.add(Integer.parseInt(part));
            }
            X = numbersList.getLast();
            int left = 0;
            int right = numbersList.size() - 1;

            while (left < right) {
                while (left < right && numbersList.get(left) <= X) {
                    left++;
                }

                while (left < right && numbersList.get(right) > X) {
                    right--;
                }

                if (left < right) {
                    int temp = numbersList.get(left);
                    numbersList.set(left, numbersList.get(right));
                    numbersList.set(right, temp);
                    left++;
                    right--;
                }
            }

            System.out.println(numbersList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

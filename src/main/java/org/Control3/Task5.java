package org.Control3;
import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        String name, number;
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
                name = sc.next();
                number = sc.next();
                if (phoneBook.containsKey(name)) {
                    phoneBook.get(name).add(number);
                }
                else {
                    List<String> numbers = new ArrayList<>();
                    numbers.add(number);
                    phoneBook.put(name, numbers);
            }
        }

        for(int i = 0; i < n; i++){
            name = sc.next();
            System.out.println(name + ": " + phoneBook.get(name));
        }
    }
}

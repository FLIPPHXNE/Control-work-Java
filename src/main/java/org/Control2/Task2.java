package org.Control2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = sc.nextLine();
        int max = -1;
        int counter = 0;
        int maxCounter = 0;
        for(int i = 0; i < str.length(); i++){
            int ascii = (int)(str.charAt(i));

            if(ascii >= max){
                if(counter > maxCounter)
                    maxCounter = counter + 1;
                max = ascii;
                counter++;
            }
            else{
                if(counter > maxCounter)
                    maxCounter = counter + 1;
                counter = 0;
                max = -1;
            }
        }
        System.out.println(maxCounter);
    }
}
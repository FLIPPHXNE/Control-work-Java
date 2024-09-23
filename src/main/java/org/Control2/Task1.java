package org.Control2;

import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        String number = sc.next();
        int index = 0;
        boolean isDouble = false;

        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) - '.' == 0) {
                index = i + 1;
                isDouble = true;
                break;
            }
        }

        boolean hasSign = number.charAt(0) - '+' == 0 || number.charAt(0) - '-' == 0;

        if(isDouble) {
            System.out.println("Кол-во знаков в целой части:\tКол-во знаков в дробной части:");
            if(hasSign) System.out.println(index - 2 + "\t" + (number.length() - index));
            else System.out.println(index - 1 + "\t" + (number.length() - index));
        }
        else{
            System.out.println("Кол-во знаков в целой части:");
                if(hasSign) System.out.println(number.length() - 1);
                else System.out.println(number.length());
            }
    }
}
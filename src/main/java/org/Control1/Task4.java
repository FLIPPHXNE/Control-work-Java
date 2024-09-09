package org.Control1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите N:");
        int N = sc.nextInt();
        int zeroCnt = 0;
        int lastDigit;

        while(N > 0){
            lastDigit = N % 10;
            if(lastDigit == 0) zeroCnt++;
            N /= 10;
        }

        System.out.printf("Количество нулей в числе: " + zeroCnt);
    }
}

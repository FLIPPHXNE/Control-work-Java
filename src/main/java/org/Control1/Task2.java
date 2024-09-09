package org.Control1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = sc.nextInt();
        double sum = 0;

        for(int i = 1; i <= n; i++){
            sum += 1 / (double)(i*i);
        }

        System.out.println("Частичная сумма равна " + sum);
    }
}

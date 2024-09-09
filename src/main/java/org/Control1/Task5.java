package org.Control1;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите N:");
        int N = sc.nextInt();

        System.out.println("Точные квадраты натур. чисел, не превосход. N:");
        for(int i = 1; i*i <= N; i++){
            System.out.println(i*i);
        }
    }
}

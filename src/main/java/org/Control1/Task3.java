package org.Control1;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите N:");
        int N = sc.nextInt();
        double sum = 0;
        int factorial = 1;

        for(int i = 0; i < N; i++){
            if(i!= 0) factorial *= i;
            sum += 1 / (double)factorial;
        }
        System.out.printf("Частичная сумма равна %.5f", sum);
    }
}

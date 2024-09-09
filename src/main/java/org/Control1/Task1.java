package org.Control1;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int nextTerm;

        while(true){
            nextTerm = sc.nextInt();
            if(nextTerm == 0) break;
            sum += nextTerm;
        }

        System.out.println(sum);
    }
}
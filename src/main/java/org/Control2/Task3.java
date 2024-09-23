package org.Control2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = sc.nextLine();
        String newStr = "";
        String[] arrStr = str.split(" ");
        int cnt = 0;
        for(String s : arrStr) {
            if(s.charAt(0) - 'a' == 0) {
                newStr += 'A' + s.substring(1) + " ";
                cnt++;
            }
            else newStr += s + " ";
        }

        System.out.println(newStr);
        System.out.println("Кол-во слов, начинающихся на «а»: " + cnt);
    }
}
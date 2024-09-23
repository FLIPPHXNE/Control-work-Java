package org.Control2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String rgb = sc.nextLine();
        Pattern pattern = Pattern.compile("^#[\\dA-F]{6}$");
        Matcher matcher = pattern.matcher(rgb);

        boolean valid = matcher.hasMatch();
        if(valid) System.out.println(rgb + " является шестнадцатиричным идентификатором цвета");
        else System.out.println(rgb + " НЕ является шестнадцатиричным идентификатором цвета");
    }
}
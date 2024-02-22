package com.myskdias.api.test.logging;

import org.fusesource.jansi.Ansi;

public class AnsiTest {

    public static void main(String[] args) {
        String s = Ansi.ansi().fg(Ansi.Color.BLUE).bold().toString();

//        String s = "\u001B[31m";
        System.out.println((int)s.toCharArray()[0]);
        char[] cs = s.toCharArray();
        for(char c : cs) {
            System.out.print(c+" ");
        }
        System.out.println();
        s = "\u001B[31m";
        System.out.println((int)s.toCharArray()[0]);
        cs = s.toCharArray();
        for(char c : cs) {
            System.out.print(c+" ");
        }
    }

}

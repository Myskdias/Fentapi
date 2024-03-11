package com.myskdias.uhc.test;

import javafx.scene.transform.Scale;

public class CalculusTest {

    public static void main(String[] args) {
        System.out.println(calc(10000,20000000,1.05f));
    }

    public static int calc(int add, float objective, float avg) {

        int y = 0;
        float r = 0;
        while(r < objective) {
            r += add*12;
            r *= avg;
            y++;
            System.out.println("y: "+y+" R = "+r);
        }
        return y;
    }

}

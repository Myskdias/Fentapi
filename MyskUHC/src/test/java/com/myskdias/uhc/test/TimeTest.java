package com.myskdias.uhc.test;

import java.util.HashMap;

public class TimeTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < 25; i++) {
            map.put("lulure"+i,"rejrezopjztepojteoptjzpoetjeoptjeotjo");
        }

        long b = System.nanoTime();
        map.get("zetok");
        long time = System.nanoTime() -  b;
        System.out.println(time);
        System.out.println(3/2);
    }

}

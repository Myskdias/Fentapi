package com.myskdias.uhc.test;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class ArrayTest {

    private static final String[] lo = new String[] {"","\u2729", "\u25a1", "\u25b3","\u25ca","\u25cb"};

    /**
     * All the symbols available for the teams
     */
    private static String[] symbols;

    public static void main(String[] args) {
        ArrayList<String> tempList = new ArrayList<>();
        for(String s : lo) {
            for(ChatColor cc : ChatColor.values()) {
                if(!cc.isFormat()) {
                    tempList.add(cc+s);
                }
            }
        }
    }


}

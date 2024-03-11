package com.myskdias.uhc.test;

import org.bukkit.Bukkit;

import java.util.function.Consumer;

public class TimerTest {

    public static void main(String[] args) {
        final Consumer<String> ee = System.out::println;
        final Consumer<String> eze = new TimerTest()::doSmth;
        eze.accept("rzr");
    }

    public void doSmth(String a) {
        System.out.println("rzer");
    }

}

package com.myskdias.api.test;


import java.util.logging.Logger;

public class LoggerTest  {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREY = "\u001B[37m";
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("test");
        for (int i = 30; i < 40; i++) {
            System.out.print(RESET);
            System.out.printf("\u001B[%02dm "+i+"\n",i);
        }
//        System.out.println(logger.getHandlers().length);
//        System.out.println("\u001B[93mrzerer");
//        for (Loggerv2.Color c : Loggerv2.Color.values()) {
//            System.out.println(c+" : "+c.name());
//        }
    }

}

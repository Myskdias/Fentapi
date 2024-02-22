package com.myskdias.api.test;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLogger;

public class Loggerv2 extends PluginLogger {

    public Loggerv2(Plugin context) {
        super(context);
    }

    public static enum Color {

        RESET("\u001B[0m"),
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        MAGENTA("\u001B[35m"),
        CYAN("\u001B[36m"),
        GREY("\u001B[37m"),

        BRIGHT_BLACK("\u001B[90m"),
        BRIGHT_RED("\u001B[91m"),
        BRIGHT_("\u001B[92m"),
        BRIGHT_YELLOW("\u001B[93m"),
        BRIGHT_BLUE("\u001B[94m"),
        BRIGHT_MAGENTA("\u001B[95m"),
        BRIGHT_CYAN("\u001B[96m"),
        BRIGHT_GREY("\u001B[97m");

        private final String ansi;

        private Color(String ansi) {
            this.ansi = ansi;
        }

        @Override
        public String toString() {
            return ansi;
        }
    }


}

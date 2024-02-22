package com.myskdias.api.logging;

public enum Color {

    RESET("\u001B[0m"),
    BRIGHT_BLACK("\u001B[30;1m"),
    BRIGHT_RED("\u001B[31;1m"),
    BRIGHT_GREEN("\u001B[32;1m"),
    BRIGHT_YELLOW("\u001B[33;1m"),
    BRIGHT_BLUE("\u001B[34;1m"),
    BRIGHT_MAGENTA("\u001B[35;1m"),
    BRIGHT_CYAN("\u001B[36;1m"),
    BRIGHT_GREY("\u001B[37;1m"),

    DARK_BLACK("\u001B[30;22m"),
    DARK_RED("\u001B[31;22m"),
    DARK_GREEN("\u001B[32;22m"),
    DARK_YELLOW("\u001B[33;22m"),
    DARK_BLUE("\u001B[34;22m"),
    DARK_MAGENTA("\u001B[35;22m"),
    DARK_CYAN("\u001B[36;22m"),
    DARK_GREY("\u001B[37;22m");

    private final String ansi;

    Color(String ansi) {
        this.ansi = ansi;
    }

    @Override
    public String toString() {
        return ansi;
    }

}

package com.myskdias.chat.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        String s = "e&ozr&5";
//        System.out.println(s.replaceAll("&[a-fA-K0-9]", "VU"));
//        String regex = "&[a-fklmnor0-9]";
//        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(s);
//        StringBuffer sb = new StringBuffer();
//        while(matcher.find()) {
//            String replacement = setChar(matcher.group(), 0, '§');
//            matcher.appendReplacement(sb, replacement);
//        }
//        matcher.appendTail(sb);
//        System.out.println(sb.toString());
        System.out.println(colorMessage(s));
    }

    public static String setChar(String s, int i, char c) {
        char[] cs = s.toCharArray();
        cs[i] = c;
        return String.valueOf(cs);
    }

    public static String colorMessage(String msg) {
        String regex = "&[a-fklmnor0-9]";
        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(msg);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            String replacement = setChar(matcher.group(), 0, '§');
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}

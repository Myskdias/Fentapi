package com.myskdias.api.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * All the useful methods that I use to code
 */
public class Utils {

    /**
     *
     * @param s The string target. String is an immutable structure, it thus won't be changed
     * @param i The index of the char which will be changed
     * @param c The new char
     * @return the string with the char c at the index i
     */
    public static String setChar(String s, int i, char c) {
        char[] cs = s.toCharArray();
        cs[i] = c;
        return String.valueOf(cs);
    }

    /**
     * color a message by replacing & by § in the right context </br>
     * Use regex to do that
     * @param msg The message needing coloration
     * @return colored msg
     */
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

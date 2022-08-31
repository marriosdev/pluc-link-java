package com.pluc.pluc.components.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkValidator {
    
    public static boolean isValid(String link) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        return IsMatch(link, regex);
    }

    private static boolean IsMatch(String s, String pattern) {
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(s);
            return matcher.matches();
        } catch (RuntimeException e) {
        return false;
        }  
    }
}

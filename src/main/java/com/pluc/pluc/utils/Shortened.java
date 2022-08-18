package com.pluc.pluc.utils;

public class Shortened {
    
    static public String generate() {
        String theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"; 
        StringBuilder  builder = new StringBuilder(10); 

        for (int i = 0; i < 10; i++) { 
            int myindex  = (int)(theAlphaNumericS.length() * Math.random()); 
            builder.append(theAlphaNumericS.charAt(myindex)); 
        } 
        return new String(builder);
    } 
}

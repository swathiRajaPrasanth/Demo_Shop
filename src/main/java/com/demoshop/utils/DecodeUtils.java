package com.demoshop.utils;

import java.util.Base64;

public class DecodeUtils {
    public static String getDecodedPassword(String encodedString) {
        if (encodedString == null || encodedString.isEmpty()) {
            return "";
        }
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes);
    }
    
}

package org.olivebh.bookstore.util;

public class Utils {
    public static Long checkValidNumber(String num) {
        try {
            return Long.parseLong(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("Expected whole number as argument");
        }
    }
}
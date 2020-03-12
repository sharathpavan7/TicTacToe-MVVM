package com.example.tictactoe_mvvm.utils;

public class StringUtils {

    public static String stringFromNumbers(int ... numbers) {
        StringBuilder builder = new StringBuilder();
        for (int number : numbers)
            builder.append(number);
        return builder.toString();
    }

    public static boolean isNullorEmpty(String value) {
        if (value == null || value.isEmpty()) return true;
        return false;
    }

}

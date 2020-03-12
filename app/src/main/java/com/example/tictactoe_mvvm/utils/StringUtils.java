package com.example.tictactoe_mvvm.utils;

public class StringUtils {

    public static boolean isNullorEmpty(String value) {
        if (value == null || value.isEmpty()) return true;
        return false;
    }

}

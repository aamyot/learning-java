package com.alexandreamyot.kata.roman;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scribe {

    private static Map<String, Integer> ROMAN_DICTIONARY = new LinkedHashMap<String, Integer>() {{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};


    public static String toRoman(int arabic) {
        String roman = "";
        if (arabic == 0) {
            return roman;
        }

        for (Map.Entry<String, Integer> entry : ROMAN_DICTIONARY.entrySet()) {
            int value = entry.getValue();
            if (arabic >= value) {
                roman += entry.getKey() + toRoman(arabic - value);
                break;
            }
        }

        return roman;
    }

    public static Integer toArabic(String roman) {
        int acc = 0;

        if (roman.isEmpty()) {
            return acc;
        }

        for (Map.Entry<String, Integer> entry : ROMAN_DICTIONARY.entrySet()) {
            String key = entry.getKey();
            if (roman.startsWith(key)) {
                acc += entry.getValue() + toArabic(roman.substring(key.length()));
                break;
            }
        }

        return acc;
    }
}

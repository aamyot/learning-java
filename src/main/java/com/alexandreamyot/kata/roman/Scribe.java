package com.alexandreamyot.kata.roman;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scribe {

    private static final Map<Integer, String> numeralToRoman = new LinkedHashMap<Integer, String>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};
    private static final Map<String, Integer> romanToNumeral = reverse(numeralToRoman);

    private static Map<String, Integer> reverse(Map<Integer, String> numeralToRoman) {
        Map<String, Integer> reversed = new LinkedHashMap<>();
        for (Map.Entry<Integer,String> entry : numeralToRoman.entrySet()) {
            reversed.put(entry.getValue(), entry.getKey());
        }
        return reversed;
    }


    public static String toRoman(int arabic) {
        return toRoman(arabic, "");
    }

    public static String toRoman(int arabic, String roman) {
        if (arabic == 0) {
            return roman;
        }

        for (Map.Entry<Integer, String> entry : numeralToRoman.entrySet()) {
            int value = entry.getKey();
            if (arabic >= value) {
                roman += numeralToRoman.get(value);
                arabic -= value;
                return toRoman(arabic, roman);
            }
        }

        return "";
    }

    public static Integer toArabic(String roman) {
        return toNumeral(roman, 0);
    }

    private static Integer toNumeral(String roman, int acc) {

        if (roman.length() == 0) {
            return acc;
        }

        for (Map.Entry<String, Integer> entry : romanToNumeral.entrySet()) {
            String key = entry.getKey();
            if (roman.startsWith(key)) {
                acc += entry.getValue();
                return toNumeral(roman.substring(key.length()), acc);
            }
        }

        return acc;
    }
}

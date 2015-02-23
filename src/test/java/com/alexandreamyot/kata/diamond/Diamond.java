package com.alexandreamyot.kata.diamond;

import java.util.ArrayList;
import java.util.List;

public class Diamond {

    private int size;

    public List<String> make(char endLetter) {
        List<String> diamond = new ArrayList<>();

        size = height(endLetter);

        if (endLetter == 'B') {
            diamond.add(level('A'));
            diamond.add("B.B");
            diamond.add(level('A'));
            return diamond;
        }

        diamond.add(String.valueOf(endLetter));
        return diamond;
    }

    private int height(char endLetter) {
        return (endLetter - 'A') * 2 -1;
    }

    public String level(char letter) {
        return paddig(size - letter) + letter + paddig(1);
    }

    private String paddig(int paddingWidth) {
        String pad = "";
        for (int i = 0; i < paddingWidth; i++) pad += ".";
        return pad;
    }
}

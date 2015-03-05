package com.alexandreamyot.kata.diamond;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class Diamond {

    private final char endLetter;

    public Diamond(char endLetter) {
        this.endLetter = endLetter;
    }

    public List<String> make() {
        List<String> diamond = new ArrayList<>();

        for (char letter = 'A'; letter <= endLetter; letter++) {
            diamond.add(line(letter));
        }

        return Stream.concat(diamond.stream(),
                             diamond.stream()
                                    .limit(diamond.size() - 1)
                                    .sorted(Collections.reverseOrder())).collect(toList());
    }

    private String line(char letter) {
        String level = level(letter);
        String padding = spacing((lineSize() - level.length()) / 2);
        return padding + level + padding;
    }

    protected String level(char letter) {
        if (letter == 'A') return valueOf('A');

        return valueOf(letter) + spacing(index(letter) * 2 - 1) + valueOf(letter);
    }

    protected int lineSize() {
        return (endLetter - 'A') * 2 + 1;
    }

    protected String spacing(int paddingWidth) {
        String pad = "";
        for (int i = 0; i < paddingWidth; i++) pad += ".";
        return pad;
    }

    private int index(char letter) {
        return letter - 'A';
    }
}

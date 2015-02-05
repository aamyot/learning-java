package com.alexandreamyot.kata.roman;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(value = Parameterized.class)
public class RomanToArabicTest {

    private final int arabic;
    private final String roman;

    public RomanToArabicTest(int arabic, String roman) {
        this.arabic = arabic;
        this.roman = roman;
    }

    @Parameterized.Parameters(name="Roman numeral of {0} is {1}")
    public static Iterable<Object[]> data() {
        return asList(new Object[][]{
                {1, "I"},
                {2, "II"},
                {4, "IV"},
                {10, "X"},
                {34, "XXXIV"},
                {3004, "MMMIV"},
                {1467, "MCDLXVII"},
                {4999, "MMMMCMXCIX"}
        });
    }

    @Test
    public void testToRoman() {
        assertThat(Scribe.toRoman(arabic), equalTo(roman));
    }
}

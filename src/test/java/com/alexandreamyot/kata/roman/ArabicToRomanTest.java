package com.alexandreamyot.kata.roman;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(value = Parameterized.class)
public class ArabicToRomanTest {

    private final int arabic;
    private final String roman;

    public ArabicToRomanTest(String roman, int arabic) {
        this.roman = roman;
        this.arabic = arabic;
    }

    @Parameterized.Parameters(name="Roman numeral of {0} is {1}")
    public static Iterable<Object[]> toArabicData() {
        return asList(new Object[][]{
                {"I", 1},
                {"II", 2},
                {"IV", 4},
                {"X", 10},
                {"XXXIV", 34},
                {"MMMIV", 3004},
                {"MCDLXVII", 1467},
                {"MMMMCMXCIX", 4999},
        });
    }

    @Test
    public void testToArabic() {
        assertThat(Scribe.toArabic(roman), equalTo(arabic));
    }
}

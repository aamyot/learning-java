package com.alexandreamyot.kata.diamond;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class DiamondTest {

    @Test
    public void diamondOfA() {
        assertThat(new Diamond().make('A'), contains("A"));
    }

    @Test
    public void diamondOfB() {
        assertThat(new Diamond().make('B'), contains(
                ".A.",
                "B.B",
                ".A."));
    }
}

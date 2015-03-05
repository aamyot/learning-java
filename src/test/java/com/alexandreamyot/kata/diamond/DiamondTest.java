package com.alexandreamyot.kata.diamond;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DiamondTest {

    @Test
    public void diamondOfA() {
        assertThat(new Diamond('A').make(), contains("A"));
    }

    @Test
    public void diamondOfB() {
        assertThat(new Diamond('B').make(), contains(
                ".A.",
                "B.B",
                ".A."));
    }

    @Test
    public void canPrintSpacing() {
        assertThat(new Diamond('A').spacing(5), equalTo("....."));
    }

    @Test
    public void lineSizeOfDiamondB() {
        assertThat(new Diamond('B').lineSize(), equalTo(3));
    }

    @Test
    public void lineSizeOfDiamondC() {
        assertThat(new Diamond('C').lineSize(), equalTo(5));
    }

    @Test
    public void levelOfA() {
        assertThat(new Diamond('C').level('A'), equalTo("A"));
    }

    @Test
    public void levelOfB() {
        assertThat(new Diamond('D').level('B'), equalTo("B.B"));
    }

    @Test
    public void levelOfD() {
        assertThat(new Diamond('D').level('D'), equalTo("D.....D"));
    }

    @Test
    public void diamondOfD() {
        assertThat(new Diamond('D').make(), contains(
                "...A...",
                "..B.B..",
                ".C...C.",
                "D.....D",
                ".C...C.",
                "..B.B..",
                "...A..."));
    }

}

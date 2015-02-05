package com.alexandreamyot.kata.roman;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class RomanTest {

    @Test
    public void _1TranslatesToI() {
        assertThat(translate(1), equalTo("I"));
    }

    @Test
    public void _2TranslatesToII() {
        assertThat(translate(2), equalTo("II"));
    }

    @Test
    public void _4TranslatesToIV() {
        assertThat(translate(4), equalTo("IV"));
    }

    @Test
    public void _10TranslatesToX() {
        assertThat(translate(10), equalTo("X"));
    }

    @Test
    public void _34TranslatesToXXXIV() {
        assertThat(translate(34), equalTo("XXXIV"));
    }

    @Test
    public void _3004TranslatesToMMMIV() {
        assertThat(translate(3004), equalTo("MMMIV"));
    }

    @Test
    public void _1467TranslatesToMCDLXVII() {
        assertThat(translate(1467), equalTo("MCDLXVII"));
    }

    @Test
    public void _4999TranslatesToMMMMCMXCIX() {
        assertThat(translate(4999), equalTo("MMMMCMXCIX"));
    }

    private String translate(int arabic) {
        return Scribe.toRoman(arabic);
    }

    @Test
    public void ITranslatesTo1() {
        MatcherAssert.assertThat(Scribe.toNumeral("I"), equalTo(1));
    }

    @Test
    public void IITranslatesTo2() {
        MatcherAssert.assertThat(Scribe.toNumeral("II"), equalTo(2));
    }

    @Test
    public void IVTranslatesTo4() {
        MatcherAssert.assertThat(Scribe.toNumeral("IV"), equalTo(4));
    }

    @Test
     public void MMMCDXLIVTranslatesTo3444() {
        MatcherAssert.assertThat(Scribe.toNumeral("MMMCDXLIV"), equalTo(3444));
    }



}

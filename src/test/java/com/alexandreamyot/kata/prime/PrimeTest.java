package com.alexandreamyot.kata.prime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class PrimeTest {

    private final int number;
    private final List<Integer> primes;

    public PrimeTest(int number, List<Integer> primes) {
        this.number = number;
        this.primes = primes;
    }

    @Parameters(name="Primes of {0} is {1}")
    public static Iterable<Object[]> data() {
        return asList(new Object[][]{
                {1, asList()},
                {2, asList(2)},
                {4, asList(2, 2)},
                {3, asList(3)},
                {9, asList(3, 3)},
                {182, asList(2, 7, 13)},
                {1000, asList(2, 2, 2, 5, 5, 5)}
        });
    }

    @Test
    public void testPrimeFactors() throws Exception {
        assertThat(PrimeFactors.generate(number), equalTo(primes));

    }

}

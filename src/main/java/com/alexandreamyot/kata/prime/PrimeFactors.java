package com.alexandreamyot.kata.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

import static java.util.Collections.emptyList;
import static java.util.stream.IntStream.rangeClosed;

public class PrimeFactors {

    public static List<Integer> generate(int number) {

        return rangeClosed(2, number)
                .filter(factorOf(number))
                .mapToObj(subPrimesOf(number))
                .findFirst()
                .orElse(emptyList());
    }

    private static IntFunction<List<Integer>> subPrimesOf(int number) {
        return candidate -> {
            List<Integer> primes = new ArrayList<>();
            primes.add(candidate);
            primes.addAll(generate(number/candidate));
            return primes;
        };
    }

    private static IntPredicate factorOf(int number) {
        return candidate -> number % candidate == 0;
    }

}

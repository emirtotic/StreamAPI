package com.streamApi.nonMatch;

import java.util.Arrays;
import java.util.List;

public class NonMatch {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 4, 2, 5, 6);
        System.out.println("Numbers are: " + numbers);

        boolean noMatch = numbers.stream().noneMatch(num -> num < 0);
        System.out.println("Every number is positive = " + noMatch);
    }
}

package com.streamApi.allMatch;

import java.util.Arrays;
import java.util.List;

public class AllMatch {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 4, 2, 5, 6);
        System.out.println("Numbers are: " + numbers);

        boolean allPositive = numbers.stream().allMatch(num -> num > 0);
        System.out.println("All numbers are positive = " + allPositive);
    }

}

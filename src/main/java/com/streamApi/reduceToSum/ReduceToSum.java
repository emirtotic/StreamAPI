package com.streamApi.reduceToSum;

import java.util.Arrays;
import java.util.List;

public class ReduceToSum {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Numbers: " + numbers);

        int total = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Total: " + total);

        // The reduce method takes an identity (0 in this case) and an
        // accumulator function (Integer::sum) to calculate the total.

    }

}

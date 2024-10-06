package com.streamApi.sumOfElements;

import java.util.Arrays;
import java.util.List;

public class SumOfElements {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        System.out.println(numbers);

        Integer sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of elements = " + sum);
    }
}

package com.streamApi.distinct;

import java.util.Arrays;
import java.util.List;

public class DistinctElements {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 4, 2, 4, 2, 4, 5, 2, 34, 3, 4);
        System.out.println("All elements: " + numbers);

        List<Integer> distinct = numbers.stream().distinct().toList();
        System.out.println("Distinct: " + distinct);

    }

}

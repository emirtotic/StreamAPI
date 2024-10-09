package com.streamApi.sortList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4, 2, 7, 3, 1, 5, 8, 6);
        System.out.println("Unsorted: " + numbers);

        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted: " + sorted);

    }

}

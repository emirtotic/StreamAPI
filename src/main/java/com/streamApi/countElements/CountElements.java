package com.streamApi.countElements;

import java.util.Arrays;
import java.util.List;

public class CountElements {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 4, 6, 3, 9, 17, 10, 2);
        System.out.println("All elements: " + numbers);

        List<Integer> greater = numbers.stream().filter(num -> num > 5).toList();
        System.out.println("Greater than 5: " + greater);

    }

}

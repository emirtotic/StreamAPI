package com.streamApi.findAny;

import java.util.Arrays;
import java.util.List;

public class FindAny {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Numbers: " + numbers);

        int number = numbers.stream().findAny().get();
        System.out.println("Found: " + number);

        int numberLarger = numbers.stream().filter(num -> num > 3).findAny().get();
        System.out.println("Found larger than 3: " + numberLarger);
    }

}

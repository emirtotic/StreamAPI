package com.streamApi.findFirst;

import java.util.Arrays;
import java.util.List;

public class FindFirst {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Numbers: " + numbers);

        int first = numbers.stream().findFirst().get();
        System.out.println("First element is: " + first);

        int firstGreater = numbers.stream().filter(num -> num > 2).findFirst().get();
        System.out.println("First greater than 2 in this list is: " + firstGreater);

    }

}

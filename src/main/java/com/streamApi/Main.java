package com.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> nums = Arrays.asList(1, 4, 2, 3, 6, 7);
        System.out.println(nums);

        List<Integer> evens = nums.stream().filter(num -> num % 2 == 0).toList();
        System.out.println(evens);

        int max = nums.stream().max(Integer::compareTo).get();
        System.out.println("Max is: " + max);

        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum is: " + sum);

        List<String> names = Arrays.asList("emir", "mateo", "john");

        List<String> allCap = names.stream().map(name -> name.toUpperCase()).toList();
        System.out.println(allCap);

        List<String> capitalized = new ArrayList<>();
        names.stream().forEach(name -> {
            capitalized.add(name.substring(0, 1).toUpperCase() + name.substring(1)
            );
        });
        System.out.println(capitalized);

        List<String> capitalizedLast = new ArrayList<>();
        names.stream().forEach(name -> {
            capitalizedLast.add(name.substring(0, name.length() - 1) + name.substring(name.length() - 1).toUpperCase());
        });

        System.out.println(capitalizedLast);

    }
}
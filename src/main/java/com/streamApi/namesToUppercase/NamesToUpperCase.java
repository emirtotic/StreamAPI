package com.streamApi.namesToUppercase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesToUpperCase {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("jimmy", "jennifer", "maria", "mark", "peter");
        System.out.println(names);

        List<String> upperNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperNames);
    }
}

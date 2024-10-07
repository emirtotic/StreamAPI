package com.streamApi.namesToCapital;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesToCapital {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("jimmy", "jennifer", "maria", "mark", "peter");
        System.out.println(names);

        List<String> capital =
                names.stream()
                        .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                        .collect(Collectors.toList());
        System.out.println(capital);
    }
}

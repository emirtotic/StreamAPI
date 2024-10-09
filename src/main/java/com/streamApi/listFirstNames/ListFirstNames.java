package com.streamApi.listFirstNames;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListFirstNames {

    public static void main(String[] args) {

        List<String> people = Arrays.asList("John Malkovich", "Quentin Tarantino", "Guy Ritchie");
        System.out.println("People: " + people);

        List<String> namesOnly = people.stream()
                .map(p -> p.split(" ") [0])
                .collect(Collectors.toList());

        System.out.println("Names: " + namesOnly);

        List<String> surnamesOnly = people.stream()
                .map(p -> p.split(" ") [1])
                .collect(Collectors.toList());

        System.out.println("Surnames: " + surnamesOnly);

    }

}

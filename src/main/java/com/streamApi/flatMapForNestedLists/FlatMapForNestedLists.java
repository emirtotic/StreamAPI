package com.streamApi.flatMapForNestedLists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapForNestedLists {

    public static void main(String[] args) {

        List<List<Integer>> nestedNumbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));

        System.out.println("Nested numbers: " + nestedNumbers);

        List<Integer> flatList = nestedNumbers.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("Flat list: " + flatList);

        System.out.println("________________________________________");

        List<List<String>> nestedCelebrities
                = Arrays.asList(Arrays.asList("John Malkovich", "Quentin Tarantino", "Guy Ritchie"),
                Arrays.asList("Robert De Niro", "Leonardo DiCaprio", "Anthony Hopkins", "Brad Pitt", "Tom Hanks"));

        System.out.println("Nested: " + nestedCelebrities);

        List<String> allInOneList = nestedCelebrities.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("All in one list: " + allInOneList);

    }
}

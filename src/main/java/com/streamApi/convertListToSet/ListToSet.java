package com.streamApi.convertListToSet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListToSet {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 6, 7, 7);
        System.out.println(list);

        Set<Integer> set = list.stream().collect(Collectors.toSet());
        //Set<Integer> set = new HashSet<>(list);  - THIS IS THE SAME AS LINE ABOVE
        System.out.println(set);

    }

}

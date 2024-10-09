package com.streamApi.skipElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkipElement {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(nums);

        List<Integer> skipped = nums.stream().skip(3).collect(Collectors.toList());
        System.out.println(skipped);



    }

}

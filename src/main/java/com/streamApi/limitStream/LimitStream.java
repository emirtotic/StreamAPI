package com.streamApi.limitStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitStream {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(nums);

        List<Integer> limited = nums.stream().limit(3).collect(Collectors.toList());
        System.out.println(limited);

    }

}

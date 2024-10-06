package com.streamApi.findMaximum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindMaximum {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 76, 45, 34, 9);
        System.out.println(nums);

        Optional<Integer> max = nums.stream().max(Integer::compare);
        System.out.println("Max is: " + max.get());

    }

}

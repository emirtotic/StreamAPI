package com.streamApi.peekElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeekElement {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        List<Integer> peekedAtNumbers = numbers.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());

        //peek is used for debugging or performing actions without changing the stream. It prints each element before passing it along the stream.

    }

}

package com.misc.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of one's and zero's convert the equivalent binary value to an integer.
 */
public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(final List<Integer> integers) {

        return
                Integer
                        .valueOf(
                                integers
                                        .stream()
                                        .map(String::valueOf)
                                        .collect(Collectors.joining())
                                , 2);
    }
}
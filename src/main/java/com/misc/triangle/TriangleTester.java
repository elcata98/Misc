package com.misc.triangle;

import java.util.stream.IntStream;

public class TriangleTester {

    public static boolean isTriangle(final int a, final int b, final int c) {

        int[] sortedSides =
                IntStream
                        .of(a, b, c)
                        .sorted()
                        .toArray();

        return sortedSides[0] + sortedSides[1] > sortedSides[2];
    }
}
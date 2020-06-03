package org.elcata98.misc.numbers;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Your task is to make a function that can take any non-negative integer as a argument
 * and return it with its digits in descending order.
 * <p>
 * Essentially, rearrange the digits to create the highest possible number.
 */
class DescendingOrder {

    static int sortDesc(final int num) {

        String numString = Integer.toString(num);

        return
                Integer.parseInt(
                        IntStream
                                .range(0, numString.length())
                                .mapToObj(i -> String.valueOf(numString.charAt(i)))
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.joining())
                );
    }
}
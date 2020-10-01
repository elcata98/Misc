package org.elcata98.misc.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PartitionSummerWinter {
    public static int partition(int[] temperatures) {

        int index = temperatures.length - 1;

        List<Integer> measures = Arrays.stream(temperatures).boxed().collect(Collectors.toList());
        boolean isWinter = false;

//        Moving from "summer" to "winter" narrowing down on temperature condition
        while (!isWinter && index >= 1) {

//          As we want the shortest "winter" possible we need to continue calculation checking for next index to narrow down
            isWinter = isWinter(index, temperatures.length, measures) && !isWinter(index - 1, temperatures.length, measures);
            --index;
        }

        return index + 1;
    }


    /*
        An index can define a possible "winter" partition if all it's elements
        are smaller than the minimum temperature of corresponding "summer" partition
    */
    private static boolean isWinter(int index, int size, List<Integer> measures) {

        Integer summerMin = measures.subList(index, size).stream().min(Integer::compareTo).get();
        return measures.subList(0, index).stream().allMatch(i -> i < summerMin);
    }
}

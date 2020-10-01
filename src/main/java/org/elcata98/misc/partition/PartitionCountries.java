package org.elcata98.misc.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionCountries {
    public static int partition(int[][] A) {

        int[][] adjacentEqual = new int[A.length][];

        for (int i = 0; i < adjacentEqual.length; ++i) {
            adjacentEqual[i] = calculateAdjacentEqualRow(i, A);
        }

//        Minimum number of countries (isolated, only 1 position)
        long countries = Arrays.stream(adjacentEqual).flatMapToInt(Arrays::stream).filter(v -> v == 0).count();

        int value = Integer.MAX_VALUE;
        int previous = value;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < adjacentEqual.length; ++i) {
            for (int j = 0; j < adjacentEqual[i].length; ++j) {
                if (adjacentEqual[i][j] != 0) {
                    value = A[i][j];
                    if (value != previous) {
                        visited.add(value);
                        if(!visited.contains(previous)) {
                            ++countries;
                        }
                        previous = value;
                    }
                }
            }
        }

        return (int) (countries + visited.size());
    }

    private static int[] calculateAdjacentEqualRow(int row, int[][] map) {

        int[] input = map[row];
        int[] adjacentEqualCount = new int[input.length];

        for (int i = 0; i < input.length; ++i) {
            int value = input[i];
            int adjacent = 0;

            if (row > 0) {
                if (map[row - 1][i] == value) {
                    ++adjacent;
                }
            }

            if (row < map.length - 1) {
                if (map[row + 1][i] == value) {
                    ++adjacent;
                }
            }

            if (i > 0) {
                if (map[row][i - 1] == value) {
                    ++adjacent;
                }
            }

            if (i < input.length - 1) {
                if (map[row][i + 1] == value) {
                    ++adjacent;
                }
            }

            adjacentEqualCount[i] = adjacent;
        }
        return adjacentEqualCount;
    }
}

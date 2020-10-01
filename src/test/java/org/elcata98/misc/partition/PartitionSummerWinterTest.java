package org.elcata98.misc.partition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class PartitionSummerWinterTest {

    @Test
    void testPartition() {

        int[] temperatures = {5, -2, 3, 8, 6};

        int winterLength = PartitionSummerWinter.partition(temperatures);

        assertSame(3, winterLength);
    }

    @Test
    void testPartition2() {

        int[] temperatures = {-5, -5, -5, -42, 6, 12};

        int winterLength = PartitionSummerWinter.partition(temperatures);

        assertSame(4, winterLength);
    }

    @Test
    void testPartitionPrivate() {

        int[] temperatures = {-5, -5, -42, -4, 6, 12};

        int winterLength = PartitionSummerWinter.partition(temperatures);

        assertSame(3, winterLength);
    }

    @Test
    void testPartitionPrivate2() {

        int[] temperatures = {-5, 12};

        int winterLength = PartitionSummerWinter.partition(temperatures);

        assertSame(1, winterLength);
    }
}

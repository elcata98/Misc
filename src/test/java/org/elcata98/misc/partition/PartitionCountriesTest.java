package org.elcata98.misc.partition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class PartitionCountriesTest {

    @Test
    void testPartition() {

        int[][] map = {{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};

        int countries = PartitionCountries.partition(map);
        assertSame(11, countries);
    }
}

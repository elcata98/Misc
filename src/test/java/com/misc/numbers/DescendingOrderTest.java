package com.misc.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DescendingOrderTest {

    @Test
    void test_01() {
        assertEquals(0, DescendingOrder.sortDesc(0));
    }

    @Test
    void test_02() {
        assertEquals(51, DescendingOrder.sortDesc(15));
    }

    @Test
    void test_03() {
        assertEquals(987654321, DescendingOrder.sortDesc(123456789));
    }
}
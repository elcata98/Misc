package com.misc.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryArrayToNumberTest {

    @Test
    void convertBinaryArrayToInt() {

        assertEquals(1, BinaryArrayToNumber.ConvertBinaryArrayToInt(Arrays.asList(0, 0, 0, 1)));
        assertEquals(15, BinaryArrayToNumber.ConvertBinaryArrayToInt(Arrays.asList(1, 1, 1, 1)));
        assertEquals(6, BinaryArrayToNumber.ConvertBinaryArrayToInt(Arrays.asList(0, 1, 1, 0)));
        assertEquals(9, BinaryArrayToNumber.ConvertBinaryArrayToInt(Arrays.asList(1, 0, 0, 1)));
    }
}
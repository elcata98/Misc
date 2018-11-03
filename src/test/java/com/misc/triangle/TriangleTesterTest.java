package com.misc.triangle;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TriangleTesterTest {

    @Test
    void publicTests() {
        assertTrue(TriangleTester.isTriangle(1,2,2));
        assertFalse(TriangleTester.isTriangle(7,2,2));
    }
}
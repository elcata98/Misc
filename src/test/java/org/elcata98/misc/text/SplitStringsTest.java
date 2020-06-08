package org.elcata98.misc.text;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitStringsTest {

    @Test
    void testEvenString() {

        String s = "abcdef";
        assertEquals("[ab, cd, ef]", Arrays.toString(SplitStrings.solution(s)));

        s = "HelloWorld";
        assertEquals("[He, ll, oW, or, ld]", Arrays.toString(SplitStrings.solution(s)));
    }

    @Test
    void testOddString() {

        String s = "abcde";
        assertEquals("[ab, cd, e_]", Arrays.toString(SplitStrings.solution(s)));

        s = "LovePizza";
        assertEquals("[Lo, ve, Pi, zz, a_]", Arrays.toString(SplitStrings.solution(s)));
    }

    @Test
    void testEmptyString() {

        assertEquals("[]", Arrays.toString(SplitStrings.solution(StringUtils.EMPTY)));
    }

    @Test
    void testNullString() {

        assertEquals("[]", Arrays.toString(SplitStrings.solution(null)));
    }

    @Test
    void testStringWithBlanks() {

        assertEquals("[]", Arrays.toString(SplitStrings.solution(StringUtils.SPACE)));

        String s = "Hello World";
        assertEquals("[He, ll, o_, Wo, rl, d_]", Arrays.toString(SplitStrings.solution(s)));

        s = "Love Pizza";
        assertEquals("[Lo, ve, _P, iz, za]", Arrays.toString(SplitStrings.solution(s)));
    }
}
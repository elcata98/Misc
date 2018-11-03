package com.misc.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NumbersTransformerTest {

    private NumbersTransformer numbersTransformer;

    @BeforeEach
    void setUp(){

        numbersTransformer = new NumbersTransformer();
    }

    @Test
    void testAdaptToRoman(){

        assertNull(numbersTransformer.adaptToRoman(0));
        assertNull(numbersTransformer.adaptToRoman(5000));

        assertEquals("I", numbersTransformer.adaptToRoman(1));
        assertEquals("II", numbersTransformer.adaptToRoman(2));
        assertEquals("III", numbersTransformer.adaptToRoman(3));
        assertEquals("IV", numbersTransformer.adaptToRoman(4));
        assertEquals("V", numbersTransformer.adaptToRoman(5));
        assertEquals("VI", numbersTransformer.adaptToRoman(6));
        assertEquals("VII", numbersTransformer.adaptToRoman(7));
        assertEquals("VIII", numbersTransformer.adaptToRoman(8));
        assertEquals("IX", numbersTransformer.adaptToRoman(9));
        assertEquals("X", numbersTransformer.adaptToRoman(10));
        assertEquals("XXX", numbersTransformer.adaptToRoman(30));
        assertEquals("XLIX", numbersTransformer.adaptToRoman(49));
        assertEquals("LXXIX", numbersTransformer.adaptToRoman(79));
        assertEquals("CCCXLIII", numbersTransformer.adaptToRoman(343));
        assertEquals("CDXCIX", numbersTransformer.adaptToRoman(499));
        assertEquals("MMMMCCCXXXII", numbersTransformer.adaptToRoman(4332));
    }
}
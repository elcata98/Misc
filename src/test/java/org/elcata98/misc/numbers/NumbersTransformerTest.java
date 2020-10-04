package org.elcata98.misc.numbers;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NumbersTransformerTest {

    private final NumbersTransformer numbersTransformer = new NumbersTransformer();

    @Test
    void testAdaptToRoman() {

        assertNull(numbersTransformer.adaptToRoman(0));
        assertNull(numbersTransformer.adaptToRoman(5000));
        assertNull(numbersTransformer.adaptToRoman(-10));

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

    @Test
    void testAdaptToArabic(){

        assertNull(numbersTransformer.adaptToArabic(StringUtils.EMPTY));
        assertNull(numbersTransformer.adaptToArabic(StringUtils.SPACE));
        assertNull(numbersTransformer.adaptToArabic(null));
        assertNull(numbersTransformer.adaptToArabic("i"));
        assertNull(numbersTransformer.adaptToArabic(" I "));
        assertNull(numbersTransformer.adaptToArabic("MAC"));

        assertEquals(1, numbersTransformer.adaptToArabic("I"));
        assertEquals(2, numbersTransformer.adaptToArabic("II"));
        assertEquals(3, numbersTransformer.adaptToArabic("III"));
        assertEquals(4, numbersTransformer.adaptToArabic("IV"));
        assertEquals(5, numbersTransformer.adaptToArabic("V"));
        assertEquals(6, numbersTransformer.adaptToArabic("VI"));
        assertEquals(7, numbersTransformer.adaptToArabic("VII"));
        assertEquals(8, numbersTransformer.adaptToArabic("VIII"));
        assertEquals(9, numbersTransformer.adaptToArabic("IX"));
        assertEquals(10, numbersTransformer.adaptToArabic("X"));
        assertEquals(30, numbersTransformer.adaptToArabic("XXX"));
        assertEquals(49, numbersTransformer.adaptToArabic("XLIX"));
        assertEquals(79, numbersTransformer.adaptToArabic("LXXIX"));
        assertEquals(343, numbersTransformer.adaptToArabic("CCCXLIII"));
        assertEquals(499, numbersTransformer.adaptToArabic("CDXCIX"));
        assertEquals(3999, numbersTransformer.adaptToArabic("MMMCMXCIX"));
    }
}
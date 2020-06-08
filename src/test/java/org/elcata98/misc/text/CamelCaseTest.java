package org.elcata98.misc.text;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CamelCaseTest {

    @Test
    void testSingleCamelCase() {

        assertEquals("camel Casing", CamelCase.camelCase("camelCasing"));
    }

    @Test
    void testMultiCamelCase() {
        assertEquals("camel Casing Test", CamelCase.camelCase("camelCasingTest"));
    }

    @Test
    void testNoCamelCase() {
        assertEquals("camelcasingtest", CamelCase.camelCase("camelcasingtest"));
    }

    @Test
    void testNullInput() {
        assertEquals(StringUtils.EMPTY, CamelCase.camelCase(null));
    }
}

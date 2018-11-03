package com.misc.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EncryptString1Test {
    
    @Test
    void testEncrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", EncryptString1.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", EncryptString1.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", EncryptString1.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", EncryptString1.encrypt("This is a test!", 3));
        assertEquals("This is a test!", EncryptString1.encrypt("This is a test!", 4));
        assertEquals("This is a test!", EncryptString1.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", EncryptString1.encrypt("This kata is very interesting!", 1));
    }

    @Test
    void testDecrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", EncryptString1.decrypt("This is a test!", 0));
        assertEquals("This is a test!", EncryptString1.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", EncryptString1.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", EncryptString1.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", EncryptString1.decrypt("This is a test!", 4));
        assertEquals("This is a test!", EncryptString1.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", EncryptString1.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    void testNullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", EncryptString1.encrypt("", 0));
        assertEquals("", EncryptString1.decrypt("", 0));
        assertNull(EncryptString1.encrypt(null, 0));
        assertNull(EncryptString1.decrypt(null, 0));
    }
}
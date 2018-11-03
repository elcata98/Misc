package com.misc.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrollTextTest {

    @Test
    void FixedTests() {

        assertEquals("Ths wbst s fr lsrs LL!",TrollText.disemvowel("This website is for losers LOL!"));

        assertEquals("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd", TrollText.disemvowel("No offense but,\nYour writing is among the worst I've ever read"));

        assertEquals( "Wht r y,  cmmnst?", TrollText.disemvowel("What are you, a communist?"));
    }
}
package com.train.management;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC18_LinearSearchBogieIDTest {
    
    @Test
    public void testSearch_BogieFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UC18_LinearSearchBogieID.linearSearch(ids, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(UC18_LinearSearchBogieID.linearSearch(ids, "BG999"));
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UC18_LinearSearchBogieID.linearSearch(ids, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UC18_LinearSearchBogieID.linearSearch(ids, "BG550"));
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] ids = {"BG101"};
        assertTrue(UC18_LinearSearchBogieID.linearSearch(ids, "BG101"));
    }
}

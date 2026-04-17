package com.train.management;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC20_SafeSearchBogieIDTest {

    @Test
    public void testSearch_ThrowsExceptionWhenEmpty() {
        String[] ids = {};
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            UC20_SafeSearchBogieID.safeSearch(ids, "BG101");
        });
        assertTrue(ex.getMessage().toLowerCase().contains("empty"));
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {
        String[] ids = {"BG101","BG205"};
        assertDoesNotThrow(() -> {
            UC20_SafeSearchBogieID.safeSearch(ids, "BG101");
        });
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {
        String[] ids = {"BG101","BG205","BG309"};
        assertTrue(UC20_SafeSearchBogieID.safeSearch(ids, "BG205"));
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {
        String[] ids = {"BG101","BG205","BG309"};
        assertFalse(UC20_SafeSearchBogieID.safeSearch(ids, "BG999"));
    }

    @Test
    public void testSearch_SingleElementValidCase() {
        String[] ids = {"BG101"};
        assertTrue(UC20_SafeSearchBogieID.safeSearch(ids, "BG101"));
    }
}

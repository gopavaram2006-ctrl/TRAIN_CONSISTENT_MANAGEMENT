package com.train.management;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC19_BinarySearchBogieIDTest {

    @Test
    public void testBinarySearch_BogieFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UC19_BinarySearchBogieID.binarySearch(ids, "BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(UC19_BinarySearchBogieID.binarySearch(ids, "BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UC19_BinarySearchBogieID.binarySearch(ids, "BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UC19_BinarySearchBogieID.binarySearch(ids, "BG550"));
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        String[] ids = {"BG101"};
        assertTrue(UC19_BinarySearchBogieID.binarySearch(ids, "BG101"));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        String[] ids = {};
        assertFalse(UC19_BinarySearchBogieID.binarySearch(ids, "BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        String[] ids = {"BG309","BG101","BG550","BG205","BG412"};
        assertTrue(UC19_BinarySearchBogieID.binarySearch(ids, "BG205"));
    }
}

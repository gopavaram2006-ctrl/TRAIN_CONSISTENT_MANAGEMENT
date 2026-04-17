package com.train.management;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC17_SortBogieNamesTest {
    
    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] names = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        UC17_SortBogieNames.sortBogieNames(names);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, names);
    }

    @Test
    public void testSort_UnsortedInput() {
        String[] names = {"Luxury", "General", "Sleeper", "AC Chair"};
        UC17_SortBogieNames.sortBogieNames(names);
        assertArrayEquals(new String[]{"AC Chair", "General", "Luxury", "Sleeper"}, names);
    }

    @Test
    public void testSort_AlreadySortedArray() {
        String[] names = {"AC Chair", "First Class", "General"};
        UC17_SortBogieNames.sortBogieNames(names);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General"}, names);
    }

    @Test
    public void testSort_DuplicateBogieNames() {
        String[] names = {"Sleeper", "AC Chair", "Sleeper", "General"};
        UC17_SortBogieNames.sortBogieNames(names);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper", "Sleeper"}, names);
    }

    @Test
    public void testSort_SingleElementArray() {
        String[] names = {"Sleeper"};
        UC17_SortBogieNames.sortBogieNames(names);
        assertArrayEquals(new String[]{"Sleeper"}, names);
    }
}

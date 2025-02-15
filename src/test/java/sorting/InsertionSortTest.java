package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Velthuizen
 * Test insertion sort
 */
class InsertionSortTest {

    @Test
    @DisplayName("Sort a list of (consecutive, positive) Integers")
    void sortIntegers() {
        List<Integer> integers = new ArrayList<>(List.of(8, 4, 5, 3, 7, 2, 6, 1));
        List<Integer> sortedIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        InsertionSort.sort(integers);

        assertEquals(sortedIntegers, integers);
    }

    @Test
    @DisplayName("Sort a list of Strings")
    void sortStrings() {
        List<String> integers = new ArrayList<>(List.of("banana", "apple", "apple", "cherry", "banana"));
        List<String> sortedIntegers = List.of("apple", "apple", "banana", "banana", "cherry");

        InsertionSort.sort(integers);

        assertEquals(sortedIntegers, integers);
    }

    @Test
    @DisplayName("Sort a list of Integers, with gaps, negative numbers en duplicates")
    void sortMixedIntegers() {
        List<Integer> integers = new ArrayList<>(List.of(3, -1, 8, 0, -5, 8, 7, -3));
        List<Integer> sortedIntegers = List.of(-5, -3, -1, 0, 3, 7, 8, 8);

        InsertionSort.sort(integers);

        assertEquals(sortedIntegers, integers);
    }
}
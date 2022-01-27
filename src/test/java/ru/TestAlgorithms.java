package ru;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.algorithms.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class for util methods for sorting tests
 */
@DisplayName("Sorting tests")
public class TestAlgorithms {

    /**
     * Size of an arrays
     */
    public static final int ARRAY_LEN = 100_000;

    /**
     * Bound for generation of test arrays
     */
    public static final int GENERATION_BOUND = 1_000_000;

    /**
     * Randomly generated array
     */
    public static Integer[] generatedArray;

    /**
     * Sorted array
     */
    public static Integer[] sortedArray;

    /**
     * Procedure of generating arrays
     */
    @BeforeAll
    static void generateArrays() {
        generatedArray = generateArray();
        sortedArray = Arrays.copyOf(generatedArray, ARRAY_LEN);
        Arrays.sort(sortedArray);
    }

    /**
     * Method for generating an array of Integers
     *
     * @return generated array
     */
    public static Integer[] generateArray() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Integer[] generatedArray = new Integer[ARRAY_LEN];
        for (int i = 0; i < ARRAY_LEN; i++)
            generatedArray[i] = random.nextInt(GENERATION_BOUND);
        return generatedArray;
    }

    /**
     * Procedure for testing
     *
     * @param sorter current sorting algorithm
     */
    public void sortTest(Sorter<Integer> sorter) {
        Integer[] arrayForSort = Arrays.copyOf(generatedArray, ARRAY_LEN);
        Instant startTime = Instant.now();
        sorter.sort(arrayForSort);
        Instant endTime = Instant.now();
        assertArrayEquals(arrayForSort, sortedArray);
        System.out.println("Sorting method time: " + (Duration.between(startTime, endTime).toMillis()) + " milliseconds.");
    }

    @Test
    @DisplayName("Bubble Sort test")
    void testBubbleSort() {
        sortTest(new BubbleSort<>());
    }

    @Test
    @DisplayName("Cocktail Shaker Sort test")
    void testCocktailShakerSort() {
        sortTest(new CocktailShakerSort<>());
    }

    @Test
    @DisplayName("Selection Sort test")
    void testSelectionSort() {
        sortTest(new SelectionSort<>());
    }

    @Test
    @DisplayName("Merge Sort test")
    void testMergeSort() {
        sortTest(new MergeSort<>());
    }

    @Test
    @DisplayName("Heap Sort test")
    void testHeapSort() {
        sortTest(new HeapSort<>());
    }

    @Test
    @DisplayName("Insertion Sort test")
    void testInsertionSort() {
        sortTest(new InsertionSort<>());
    }

    @Test
    @DisplayName("Odd-even Sort test")
    void testOddEvenSort() {
        sortTest(new OddEvenSort<>());
    }

    @Test
    @DisplayName("Comb Sort test")
    void testCombSort() {
        sortTest(new CombSort<>());
    }

    @Test
    @DisplayName("Shell Sort test")
    void testShellSort() {
        sortTest(new ShellSort<>());
    }

    @Test
    @DisplayName("Binary Insertion Sort test")
    void testBinaryInsertionSort() {
        sortTest(new BinaryInsertionSort<>());
    }

    @Test
    @DisplayName("Cycle Sort test")
    void testCycleSort() {
        sortTest(new CycleSort<>());
    }

    @Test
    @DisplayName("Gnome Sort test")
    void testGnomeSort() {
        sortTest(new GnomeSort<>());
    }

}

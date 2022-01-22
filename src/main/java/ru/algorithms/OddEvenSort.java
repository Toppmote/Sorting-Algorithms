package ru.algorithms;

import ru.utils.SortingUtils;

/**
 * Implementation of "Odd-even sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(n^2)
 * Best time: 0(n)
 * <p>
 * Memory cost: 0(1)
 *
 * @param <T> Data type of array elements
 */
public class OddEvenSort<T extends Comparable<? super T>> implements Sorter<T> {

    /**
     * In the odd phase, we perform a bubble sort on odd indexed elements and in the even phase,
     * we perform a bubble sort on even indexed elements.
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 1; i < array.length - 2; i += 2)
                if (array[i].compareTo(array[i + 1]) > 0) {
                    SortingUtils.swap(array, i, i + 1);
                    isSorted = false;
                }
            for (int i = 0; i < array.length - 2; i += 2)
                if (array[i].compareTo(array[i + 1]) > 0) {
                    SortingUtils.swap(array, i, i + 1);
                    isSorted = false;
                }
        } while (!isSorted);
    }

}

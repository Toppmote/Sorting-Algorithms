package ru.algorithms;

import ru.utils.SortingUtils;

/**
 * Implementation of "Insertion sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(n^2)
 * Best time: 0(n)
 * <p>
 * Memory cost: 0(1)
 *
 * @param <T> Data type of array elements
 */
public class InsertionSort<T extends Comparable<? super T>> implements Sorter<T> {

    /**
     * 1. Iterate from array[1] to array[n] over the array;
     * 2. Compare the current element to its predecessor;
     * 3. If the current element is smaller than its predecessor, compare it to the elements before.
     * Move the greater elements one position up to make space for the swapped element.
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            int currIndex = i;
            while (currIndex != 0 && array[currIndex].compareTo(array[currIndex - 1]) < 0) {
                SortingUtils.swap(array, currIndex, --currIndex);
            }
        }
    }
}

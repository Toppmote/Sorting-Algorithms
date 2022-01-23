package ru.algorithms;

import java.util.Arrays;

/**
 * Implementation of "Binary Insertion sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(n^2)
 * Best time: 0(nlog(n))
 * <p>
 * Memory cost: 0(1)
 *
 * @param <T> Data type of array elements
 */
public class BinaryInsertionSort<T extends Comparable<? super T>> implements Sorter<T> {

    /**
     * Binary Insertion Sort uses binary search to find the proper location to insert the selected item at each iteration.
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        int length = array.length;
        for (int i = 1; i < length; ++i) {
            T key = array[i];
            int insertedPosition = Math.abs(binarySearch(array, i, key) + 1);
            System.arraycopy(array, insertedPosition, array, insertedPosition + 1, i - insertedPosition);
            array[insertedPosition] = key;
        }
    }

    /**
     * Binary search implementation. Based on private method Arrays.binarySearch0()
     *
     * @param array    array for search
     * @param endIndex end index of searching
     * @param key      key for search
     * @return index of element
     * @see Arrays
     */
    private int binarySearch(T[] array, int endIndex, T key) {
        int left = 0;
        int right = endIndex - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            T middleValue = array[middle];
            if (middleValue.compareTo(key) > 0) right = middle - 1;
            else if (middleValue.compareTo(key) < 0) left = middle + 1;
            else return middle;
        }
        return -(left + 1);
    }

}

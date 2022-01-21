package ru.algorithms;

import java.sql.Array;
import java.util.Arrays;

/**
 * Implementation of "Merge sort" algorithm.
 * Worst time: 0(nlog(n))
 * Average time: 0(nlog(n))
 * Best time: 0(nlog(n))
 * <p>
 * Memory cost: 0(1) for list, 0(n) for array
 *
 * @param <T> Data type of array elements
 */
public class MergeSort<T extends Number> implements Sorter<T> {

    /**
     * Divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves.
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        this.mergeSort(array, 0, array.length - 1);
    }

    /**
     * Main function of algorithm
     *
     * @param array array for sorting
     * @param left  left border of an array
     * @param right right border of an array
     */
    private void mergeSort(T[] array, int left, int right) {
        if (left >= right)
            return;
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    /**
     * Procedure of merging 2 arrays
     *
     * @param array  array (contains 2 arrays)
     * @param left   left index (beginning of first array)
     * @param middle middle index
     * @param right  right index (end of second array)
     */
    private void merge(T[] array, int left, int middle, int right) {
        int leftLength = middle - left + 1;
        int rightLength = right - middle;
        T[] leftArr = Arrays.copyOfRange(array, left, middle + 1);
        T[] rightArr = Arrays.copyOfRange(array, middle + 1, right + 1);
        int i = 0, j = 0;
        int k = left;
        while (i < leftLength && j < rightLength)
            array[k++] = leftArr[i].doubleValue() <= rightArr[j].doubleValue() ? leftArr[i++] : rightArr[j++];
        while (i < leftLength)
            array[k++] = leftArr[i++];
        while (j < rightLength)
            array[k++] = rightArr[j++];
    }

}

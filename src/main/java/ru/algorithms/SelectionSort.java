package ru.algorithms;

import ru.utils.SortingUtils;

/**
 * Implementation of "Selection sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(n^2)
 * Best time: 0(n^2)
 * <p>
 * Memory cost: 0(1)
 *
 * @param <T> Data type of array elements
 */
public class SelectionSort<T extends Number> implements Sorter<T> {

    /**
     * In each iteration, we assume that the first unsorted element is the minimum and iterate through the rest to see
     * if there's a smaller element. Once we find the current minimum of the unsorted part of the array,
     * we swap it with the first element and consider it a part of the sorted array.
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++)
                if (array[j].doubleValue() < array[minIndex].doubleValue())
                    minIndex = j;
            if (minIndex != i)
                SortingUtils.swap(array, i, minIndex);
        }
    }
}

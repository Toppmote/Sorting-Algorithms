package ru.algorithms;

import ru.utils.SortingUtils;

/**
 * Implementation of "Comb sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(n^2 / 2^p), where p - number of increments
 * Best time: 0(nlog(n))
 * <p>
 * Memory cost: 0(1)
 *
 * @param <T> Data type of array elements
 */
public class CombSort<T extends Comparable<? super T>> implements Sorter<T> {

    /**
     * Reduction factor (also known as Shrink factor)
     */
    private static final double shrinkFactor = 1.247330950103979;

    /**
     *  Improves on Bubble Sort by using gap of size more than 1. The gap starts with a large value and shrinks
     *  by a factor of 1.3 in every iteration until it reaches the value 1.
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        int arrayLen = array.length;
        int gap = arrayLen;
        boolean isSwapped;
        do {
            gap = (int) (gap / shrinkFactor);
            if(gap < 1)
                gap = 1;
            isSwapped = false;
            for (int i = 0; i < arrayLen - gap; i++)
                if (array[i].compareTo(array[i + gap]) > 0) {
                    SortingUtils.swap(array, i, i + gap);
                    isSwapped = true;
                }
        } while (isSwapped || gap != 1);
    }
}

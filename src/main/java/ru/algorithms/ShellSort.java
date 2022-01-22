package ru.algorithms;

import ru.utils.SortingUtils;

/**
 * Implementation of "Shell sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(nlog^2(n))
 * Best time: 0(nlog(n))
 * <p>
 * Memory cost: 0(n) in total, 0(1) additionally
 *
 * @param <T> Data type of array elements
 */
public class ShellSort <T extends Comparable<? super T>> implements Sorter<T> {

    /**
     * First sorts elements that are far apart from each other and successively reduces the interval between
     * the elements to be sorted. The interval between the elements is reduced based on the sequence used.
     * Current sequence: arrLength / 2, arrLength / 4, arrLength / 8, ... , 1
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        int arrLength = array.length;
        for(int gap = arrLength / 2; gap > 0; gap /= 2)
            for(int i = gap; i < arrLength; i++) {
                for (int j = i; j >= gap && array[j - gap].compareTo(array[j]) > 0; j -= gap)
                    SortingUtils.swap(array, j, j - gap);
            }
    }
}

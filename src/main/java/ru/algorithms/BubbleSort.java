package ru.algorithms;

import ru.utils.SortingUtils;

/**
 * Implementation of "Bubble sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(n^2)
 * Best time: 0(n)
 *
 * Memory cost: 0(1)
 *
 * @param <T> Data type of array elements
 */
public class BubbleSort<T extends Number> implements Sorter<T>{

    /**
     * Just swap adjacent elements if they are in the wrong order
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        for(int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if(array[j].doubleValue() > array[j + 1].doubleValue())
                    SortingUtils.swap(array, j, j + 1);
    }

}

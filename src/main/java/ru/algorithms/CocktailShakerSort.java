package ru.algorithms;

import ru.utils.SortingUtils;

/**
 * Implementation of "Cocktail shaker sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(n^2)
 * Best time: 0(n)
 * <p>
 * Memory cost: 0(1)
 *
 * @param <T> Data type of array elements
 */
public class CocktailShakerSort<T extends Number> implements Sorter<T> {

    /**
     * Like "Bubble sort", but traverses through a given array in both directions alternatively.
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        boolean isSwapped = false;
        int start = 0;
        int end = array.length;
        do {
            for (int i = 0; i < array.length - 1; i++)
                if (array[i].doubleValue() > array[i + 1].doubleValue()) {
                    SortingUtils.swap(array, i, i + 1);
                    isSwapped = true;
                }
            if (!isSwapped)
                break;
            isSwapped = false;
            end--;
            for (int i = end - 1; i >= start; i--)
                if (array[i].doubleValue() > array[i + 1].doubleValue()) {
                    SortingUtils.swap(array, i, i + 1);
                    isSwapped = true;
                }
            start++;
        } while (isSwapped);
    }
}

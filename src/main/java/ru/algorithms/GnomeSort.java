package ru.algorithms;

import ru.utils.SortingUtils;

/**
 * Implementation of "Gnome (Stupid) sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(n^2)
 * Best time: 0(n)
 * <p>
 * Memory cost: 0(1)
 *
 * @param <T> Data type of array elements
 */
public class GnomeSort<T extends Comparable<? super T>> implements Sorter<T> {

    /**
     * 1. If the current array element is larger or equal to the previous array element then go one step right;
     * 2. If the current array element is smaller than the previous array element then swap these two elements and
     * go one step backwards;
     * 3. Repeat steps 1 and 2 while current index < array length
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        int currIndex = 1;
        while(currIndex < array.length) {
            if (array[currIndex - 1].compareTo(array[currIndex]) > 0) {
                SortingUtils.swap(array, currIndex - 1, currIndex);
                currIndex--;
            }
            else
                currIndex++;
            if (currIndex == 0)
                currIndex++;
        }
    }
}

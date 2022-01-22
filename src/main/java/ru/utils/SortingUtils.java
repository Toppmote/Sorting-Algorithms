package ru.utils;

/**
 * Class with util methods for sorting
 */
public class SortingUtils {

    /**
     * Procedure for swapping two elements of array
     *
     * @param array       array
     * @param firstIndex  index of first element
     * @param secondIndex index of second element
     * @param <T>         Data type of array elements
     */
    public static <T extends Comparable<? super T>> void swap(T[] array, int firstIndex, int secondIndex) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

}

package ru.algorithms;

/**
 * Common interface for all sorting algorithms
 *
 * @param <T> Data type of array elements
 */
public interface Sorter<T extends Number> {

    /**
     * Method for sorting an array
     *
     * @param array array for sorting
     */
    void sort(T[] array);

}

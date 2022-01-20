package ru.algorithms;

/**
 * Common interface for all sorting algorithms
 */
public interface Sorter<T extends Number> {

    T[] sort(T[] array);

}

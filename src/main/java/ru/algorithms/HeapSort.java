package ru.algorithms;

import ru.utils.SortingUtils;

/**
 * Implementation of "Heap sort" algorithm.
 * Worst time: 0(nlog(n))
 * Average time: 0(nlog(n))
 * Best time: 0(nlog(n))
 * <p>
 * Memory cost: 0(1)
 *
 * @param <T> Data type of array elements
 */
public class HeapSort<T extends Comparable<? super T>> implements Sorter<T> {

    /**
     * 1. Build a max heap from the array;
     * 2. Swap max element with the last element of the heap;
     * 3. Rearrange new root of the heap;
     * 4. Repeat step 2 while the size of the heap is greater than 1.
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        int arrLength = array.length;
        buildMaxHeap(array);
        for (int i = arrLength - 1; i > 0; i--) {
            SortingUtils.swap(array, 0, i);
            rearrangeHeap(array, i, 0);
        }
    }

    /**
     * Procedure of building max heap from array
     *
     * @param array array
     */
    private void buildMaxHeap(T[] array) {
        int arrLength = array.length;
        for (int i = arrLength / 2 - 1; i >= 0; i--)
            rearrangeHeap(array, arrLength, i);
    }

    /**
     * Procedure of rearranging node in heap.
     * Find the max element among the parent (nodeIndex) and children. If parent is not the max element,
     * then swap the parent and the max element, then call the function again for
     *
     * @param array     heap, that stored in an array
     * @param heapSize  size of the heap
     * @param nodeIndex index of node
     */
    private void rearrangeHeap(T[] array, int heapSize, int nodeIndex) {
        int leftChildIndex = 2 * nodeIndex + 1;
        int rightChildIndex = 2 * nodeIndex + 2;
        int maxElemIndex = nodeIndex;
        if (leftChildIndex < heapSize && array[leftChildIndex].compareTo(array[maxElemIndex]) > 0)
            maxElemIndex = leftChildIndex;
        if (rightChildIndex < heapSize && array[rightChildIndex].compareTo(array[maxElemIndex]) > 0)
            maxElemIndex = rightChildIndex;
        if (maxElemIndex != nodeIndex) {
            SortingUtils.swap(array, maxElemIndex, nodeIndex);
            rearrangeHeap(array, heapSize, maxElemIndex);
        }
    }
}

package ru.algorithms;

/**
 * Implementation of "Cycle sort" algorithm.
 * Worst time: 0(n^2)
 * Average time: 0(n^2)
 * Best time: 0(n^2)
 * <p>
 * Memory cost: 0(n) in total, 0(1) additionally
 *
 * @param <T> Data type of array elements
 */
public class CycleSort<T extends Comparable<? super T>> implements Sorter<T> {

    /**
     * 1. Find the index of the start element of the cycle at which it will occur in the sorted list by simply counting
     * the number of elements in the entire list that are smaller than current;
     * 2. If the start element is already at the correct position(cycleStart == currPos), do nothing;
     * 3. If it is not, we will write it to its intended position. That position is inhabited by a different element,
     * which we then have to move to its correct position. This process of displacing elements to their correct positions
     * continues until an element is moved to the original position of the start element.
     * <p>
     * Repeat this process for each element
     *
     * @param array array for sorting
     */
    @Override
    public void sort(T[] array) {
        int arrayLength = array.length;
        for (int cycleStart = 0; cycleStart < arrayLength - 1; cycleStart++) {
            T currElem = array[cycleStart];
            int currPos = cycleStart;
            for (int i = cycleStart + 1; i < arrayLength; i++)
                if (currElem.compareTo(array[i]) > 0)
                    currPos++;
            if (currPos == cycleStart)
                continue;
            while (currElem.compareTo(array[currPos]) == 0)
                currPos++;
            if (currPos != cycleStart) {
                T temp = array[currPos];
                array[currPos] = currElem;
                currElem = temp;
            }
            while (currPos != cycleStart) {
                currPos = cycleStart;
                for (int i = cycleStart + 1; i < arrayLength; i++)
                    if (currElem.compareTo(array[i]) > 0)
                        currPos++;
                while (currElem.compareTo(array[currPos]) == 0)
                    currPos++;
                if (currElem.compareTo(array[currPos]) != 0) {
                    T temp = array[currPos];
                    array[currPos] = currElem;
                    currElem = temp;
                }
            }
        }
    }
}

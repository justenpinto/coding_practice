package ideserve.arrays.q8;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.ideserve.co.in/learn/find-the-nth-most-frequent-number-in-array
 */
public class FindNthNumberOccurrence {

    public static void main(String[] args) {
        findNthFrequency(new int[]{1,2,2,3,3}, 1);
        findNthFrequency(new int[]{1,2,2,3,3}, 2);
        findNthFrequency(new int[]{1,2,2,3,3}, 3);
    }

    private static void findNthFrequency(int[] a, int n) {
        Map<Integer, Integer> table = new HashMap<>();

        for (int value : a) {
            if (table.containsKey(value)) {
                table.put(value, table.get(value) + 1);
            }
            else {
                table.put(value, 1);
            }
        }

        NumberFrequencyTuple[] maxHeap = buildMaxHeap(constructTupleArray(table), table.size());

        int heapSize = maxHeap.length;
        int nthNumber = 0;
        for (int i = 0; i < n; i++) {
            nthNumber = extractMax(maxHeap, heapSize--);
        }
        System.out.println(n + " Number: " + nthNumber);
    }

    // O(n) runtime
    // O(n) space
    private static NumberFrequencyTuple[] constructTupleArray(Map<Integer, Integer> table) {
        NumberFrequencyTuple[] tupleArray = new NumberFrequencyTuple[table.size()];
        int count = 0;
        for (Map.Entry<Integer, Integer> kvp : table.entrySet()) {
            tupleArray[count++] = new NumberFrequencyTuple(kvp.getKey(), kvp.getValue());
        }
        return tupleArray;
    }

    // O(n) runtime
    private static NumberFrequencyTuple[] buildMaxHeap(NumberFrequencyTuple[] array, int heapSize) {
        int lastElementIndex = array.length - 1;
        int parentIndex = (lastElementIndex - 1) / 2;
        for (int i = parentIndex; i >= 0; i--) {
            maxHeapify(array, i, heapSize);
        }
        return array;
    }

    // O(lg n) runtime
    private static void maxHeapify(NumberFrequencyTuple[] array, int currentIndex, int heapSize) {
        int leftIndex = 2 * currentIndex + 1;
        int rightIndex = leftIndex + 1;

        int largestIndex = currentIndex;

        // Check if left is largest
        if (leftIndex < heapSize && array[leftIndex].getFrequency() > array[currentIndex].getFrequency()) {
            largestIndex = leftIndex;
        }

        // Check if right is largest
        if (rightIndex < heapSize && array[rightIndex].getFrequency() > array[largestIndex].getFrequency()) {
            largestIndex = rightIndex;
        }

        // Need to swap if largestIndex is different than currentIndex
        if (largestIndex != currentIndex) {
            swap(array, currentIndex, largestIndex);
            maxHeapify(array, largestIndex, heapSize);
        }
    }

    private static int extractMax(NumberFrequencyTuple[] array, int heapSize) {
        int max = array[0].getNumber();
        swap(array, 0, heapSize - 1);
        maxHeapify(array, 0, heapSize - 1);
        return max;
    }

    // O(1) runtime
    private static void swap(NumberFrequencyTuple[] array, int a, int b) {
        NumberFrequencyTuple temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


}

class NumberFrequencyTuple {
    int number, frequency;

    public NumberFrequencyTuple(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getNumber() {
        return number;
    }
}

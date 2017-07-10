package ideserve.arrays.q13;

/**
 * http://www.ideserve.co.in/learn/heap-sort
 */
public class Heapsort {

    public static void main(String[] args) {
        int[] sortedArray = sortArray(new int[] {12, 35, 87, 26, 9, 28, 7});

        printArray("Sorted Array:", sortedArray);
    }

    private static void printArray(String prefix, int[] a) {
        System.out.print(prefix + " ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] sortArray(int[] a) {
        // build heap
        buildHeap(a);
        printArray("Heapified Array:", a);

        // heapify
        heapSort(a, a.length);

        return a;
    }

    private static void heapSort(int[] a, int heapSize) {
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, heapSize - 1);
            heapify(a, 0, --heapSize);
        }
    }

    private static void buildHeap(int[] a) {
        int parentLastIndex = (a.length - 2) / 2;
        for (int i = parentLastIndex; i >= 0; i--) {
            heapify(a, i, a.length);
        }
    }

    private static void heapify(int[]a, int currentIndex, int heapSize) {
        if (heapSize == 0) {
            return;
        }
        int largestIndex = currentIndex;
        for (int i = 1; i < 3; i++) {
            int childIndex = (2 * currentIndex) + i;
            if (childIndex < heapSize && a[largestIndex] < a[childIndex]) {
                largestIndex = childIndex;
            }
        }

        if (largestIndex != currentIndex) {
            swap(a, largestIndex, currentIndex);
            heapify(a, largestIndex, heapSize);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

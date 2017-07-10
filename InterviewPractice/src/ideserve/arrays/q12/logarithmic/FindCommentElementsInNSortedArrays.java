package ideserve.arrays.q12.logarithmic;

/**
 * http://www.ideserve.co.in/learn/find-common-elements-in-n-sorted-arrays
 */
public class FindCommentElementsInNSortedArrays {

    public static void main(String[] args) {
        System.out.println("First set:");
        findCommentElements(new int[][]
                {
                    {23, 34, 67, 89, 123, 566, 1000},
                    {11, 22, 23, 24,33, 37, 185, 566, 987, 1223, 1234},
                    {23, 43, 67, 98, 566, 678},
                    {1, 4, 5, 23, 34, 76, 87, 132, 566, 665},
                    {1, 2, 3, 23, 24, 344, 566}
                }
        );
        System.out.println();
        System.out.println("Second set:");
        findCommentElements(new int[][]
                {
                    {1, 3, 4, 4, 5, 43, 67, 98, 566, 678},
                    {1, 4, 4, 5, 23, 34, 76, 87, 132, 566, 665},
                    {1, 2, 4, 4, 5, 23, 24, 344, 566}
                }
        );
    }

    /**
     * O(m * (lg n1 + lg n2 + .. + lg nk)) runtime, 'm' is length of base array, 'k' is number of sorted arrays
     * O(n) space)
     * @param a
     */
    private static void findCommentElements(int[][] a) {
        int[] lastLookedIndex = new int[a.length];
        for (int i = 0; i < lastLookedIndex.length; i++) {
            lastLookedIndex[i] = 0;
        }
        for (int i = 0; i < a[0].length; i++) {
            int element = a[0][i];
            boolean result = true;
            for (int j = 1; j < a.length; j++) {
                // Run binary search with low = last searched index
                int r = binarySearch(lastLookedIndex[j], a[j].length, a[j], j, lastLookedIndex, element);
                result = (r != -1);
            }
            if (result) {
                System.out.print(element + " ");
            }
        }
    }

    private static int binarySearch(int low, int high, int[] a, int j, int[] lastLookedIndex, int element) {
        int mid = (low + high) / 2;

        if (a[mid] == element) {
            lastLookedIndex[j] = mid + 1;
            return mid;
        }
        if (low == high) {
            lastLookedIndex[j] = low;
            return -1;
        }

        if (a[mid] > element) {
            high = mid;
        }
        if (a[mid] < element) {
            low = mid + 1;
        }
        return binarySearch(low, high, a, j, lastLookedIndex, element);
    }
}

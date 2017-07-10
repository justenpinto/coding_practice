package ideserve.arrays.q12.linear;

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
     * O(m1 + m2 + .. + mn) runtime, where m is length of the nth sorted array
     * O(n) space
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
                for (int k = lastLookedIndex[j]; k < a[j].length; k++) {
                    if (a[j][k] == element) {
                        lastLookedIndex[j] = k + 1;
                        break;
                    }
                    if (a[j][k] > element) {
                        lastLookedIndex[j] = k;
                        result = false;
                        break;
                    }
                    if (k == a[j].length - 1) {
                        result = false;
                        break;
                    }
                }
            }
            if (result) {
                System.out.print(element + " ");
            }
        }
    }
}

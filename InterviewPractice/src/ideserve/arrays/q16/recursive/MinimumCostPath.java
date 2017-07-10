package ideserve.arrays.q16.recursive;

/**
 * http://www.ideserve.co.in/learn/minimum-cost-path
 */
public class MinimumCostPath {

    public static void main(String[] args) {
        System.out.println("Minimum path " + findMinimumCost(new int[][]{
                {3,2,8},
                {1,9,7},
                {0,5,2},
                {6,4,3}}, 3, 2));
    }

    /**
     * O(3^n) runtime
     * O(1) space
     * @param matrix
     */
    private static int findMinimumCost(int[][] matrix, int n, int m) {
        if (n < 0 || m < 0) {
            return Integer.MAX_VALUE;
        }
        if (n == 0 && m == 0) {
            return matrix[0][0];
        }

        return matrix[n][m] + min(
                findMinimumCost(matrix, n-1, m-1),
                findMinimumCost(matrix, n, m-1),
                findMinimumCost(matrix, n-1, m)
        );
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b,c));
    }
}

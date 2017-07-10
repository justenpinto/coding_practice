package ideserve.arrays.q4;

import static java.lang.Math.min;

/**
 * http://www.ideserve.co.in/learn/maximum-size-square-sub-matrix-with-all-1s
 */
public class FindLargestSubMatrixOfOnes {

    public static void main(String[] args) {
        findLargestSubMatrix(new int[][]{
                {0,1,1,1,1},
                {1,1,1,1,0},
                {0,1,1,1,1},
                {1,0,1,1,0},
                {0,0,1,1,0}});
    }

    /**
     * O(m*n) Runtime
     * O(m*n) Space
     * @param matrix
     */
    private static void findLargestSubMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] table = new int[m][n];

        int maxSize = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = matrix[i][j];
                }
                else if (matrix[i][j] == 0) {
                    table[i][j] = 0;
                }
                else {
                    table[i][j] = min(table[i-1][j-1], min(table[i][j-1], table[i-1][j])) + 1;
                    if (table[i][j] > maxSize) {
                        maxSize = table[i][j];
                    }
                }
            }
        }
        System.out.println("Max matrix size: " + maxSize);
    }
}

package ideserve.arrays.q16.dynamic;

/**
 * Created by justenpinto on 2017-07-09.
 */
public class MinimumCostPath {

    public static void main(String[] args) {
        printMinimumPath(new int[][]{
                {3,2,8},
                {1,9,7},
                {0,5,2},
                {6,4,3}});
    }

    /**
     * O(n*m) runtime
     * O(n*m) space
     * @param matrix
     */
    private static void printMinimumPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] costMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                costMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        costMatrix[0][0] = matrix[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 1 < m)
                    costMatrix[i][j+1] = Math.min(costMatrix[i][j+1], costMatrix[i][j] + matrix[i][j+1]);
                if (i + 1 < n)
                    costMatrix[i+1][j] = Math.min(costMatrix[i+1][j], costMatrix[i][j] + matrix[i+1][j]);
                if (i + 1 < n && j + 1 < m)
                    costMatrix[i+1][j+1] = Math.min(costMatrix[i+1][j+1], costMatrix[i][j] + matrix[i+1][j+1]);
            }
        }
        System.out.println("Minimum cost: " + costMatrix[n - 1][m - 1]);
    }
}

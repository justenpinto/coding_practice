package ideserve.arrays.q6;

/**
 * http://www.ideserve.co.in/learn/number-of-clusters-of-1s
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        System.out.println("Number of clusters: " + findNumberOfIslands(new int[][]{
                {1,0,1},
                {0,0,0},
                {1,0,1}}));
    }

    /**
     * O(m*n) runtime
     * O(m*n) space
     * @param matrix
     * @return
     */
    private static int findNumberOfIslands(int[][] matrix) {
        int numClusters = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] clusterMatrix = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 1 && !clusterMatrix[i][j]) {
                    ++numClusters;
                    clusterMatrix[i][j] = true;
                    markCluster(matrix, clusterMatrix, i, j);
                }
            }
        }
        return numClusters;
    }

    private static void markCluster(int[][] matrix, boolean[][] clusterMatrix, int i_start, int j_start) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j<= 1; j++) {
                int m = i_start + i;
                int n = j_start + j;
                if (m < 0 || n < 0 || m >= matrix.length || n >= matrix[0].length) {
                    continue;
                }

                if (matrix[m][n] == 1 && !clusterMatrix[m][n]) {
                    clusterMatrix[m][n] = true;
                    markCluster(matrix, clusterMatrix, m, n);
                }
            }
        }
    }
}

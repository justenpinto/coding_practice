package ideserve.arrays.q5;

/**
 * Created by justenpinto on 2017-07-05.
 */
public class PrintMatrixDiagonal {

    public static void main(String[] args) {
        printMatrixDiagonally(new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}});
    }

    /**
     * O(m*n) runtime
     * O(1) space
     * @param matrix
     */
    private static void printMatrixDiagonally(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int i_temp = i;
            printDiagonalRow(matrix, i_temp, 0);
        }
        for (int j = 1; j < matrix[0].length; j++) {
            printDiagonalRow(matrix, matrix.length - 1, j);
        }
    }

    private static void printDiagonalRow(int[][] matrix, int i, int j) {
        while (i >= 0 && j <= matrix.length) {
            System.out.print(matrix[i][j] + " ");
            i--;
            j++;
        }
        System.out.print("\n");
    }

}

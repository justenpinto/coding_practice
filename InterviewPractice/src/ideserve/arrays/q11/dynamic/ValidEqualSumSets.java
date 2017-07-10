package ideserve.arrays.q11.dynamic;

/**
 * Created by justenpinto on 2017-07-07.
 */
public class ValidEqualSumSets {

    public static void main(String[] args) {
        System.out.println(isValidSet(new int[]{7,5,3,5}));
        System.out.println(isValidSet(new int[]{15,5,15,20,45}));
        System.out.println(isValidSet(new int[]{21,33,37,2}));
    }

    /**
     * O(m*n) runtime, where 'n' is the sum of all elements in the set
     * O(m*n) space, where 'n' is the sum of all the elements in the set
     * @param a
     * @return
     */
    private static boolean isValidSet(int[] a) {
        int sum = 0;
        for (int v : a) {
            sum += v;
        }

        if (sum % 2 == 1) {
            System.out.println("Odd sum for entire array: false");
            return false;
        }

        boolean[][] matrix = new boolean[sum/2 + 1][a.length + 1];
        for (int j = 0; j <= a.length; j++) {
            matrix[0][j] = true;
        }

        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < sum/2; i++) {
                if (matrix[i][j]) {
                    // Set column to the right as true (additional element doesn't affect current sum)
                    matrix[i][(j + 1)] = true;

                    // Set column to right and additive of the current sum to the value as true
                    if (i + a[j] <= sum/2) {
                        matrix[(i + a[j])][j+1] = true;
                    }
                }
            }
        }

        return matrix[sum/2][a.length];

    }
}

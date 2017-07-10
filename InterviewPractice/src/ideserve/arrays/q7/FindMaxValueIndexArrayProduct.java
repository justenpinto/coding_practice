package ideserve.arrays.q7;

/**
 * http://www.ideserve.co.in/learn/maximum-value-of-index-element-product-sum-with-only-rotations
 */
public class FindMaxValueIndexArrayProduct {

    public static void main(String[] args) {
        findMax(new int[]{24,26,25,22});
    }

    // O(n) runtime
    // O(1) space
    private static void findMax(int[] a) {
        int array_sum = 0;
        for (int value : a) {
            array_sum += value;
        }

        int maxValue = 0;
        int prev_sum = 0;
        for (int i = 0; i < a.length; i++) {
            prev_sum += (i * a[i]);
        }

        for (int i = 1; i < a.length; i++) {
            int sum = prev_sum + array_sum - (a.length * a[a.length - i]);
            System.out.println("Sum of " + i + "th rotation: " + sum);
            prev_sum = sum;
            if (sum > maxValue) {
                maxValue = sum;
            }
        }
        System.out.println("Max value: " + maxValue);
    }
}

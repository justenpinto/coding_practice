package ideserve.arrays.q20;

/**
 * http://www.ideserve.co.in/learn/maximum-subarray-sum
 */
public class MaximumSubarraySum {

    public static void main(String[] args) {
        int max = findMaximumSubarraySum(new int[]{2, -9, 5, 1, -4, 6, 0, -7, 8});
        System.out.println(max);
    }

    /**
     * O(n) runtime
     * O(1) space
     *
     * Case not currently handled when array contains all negative numbers
     * @param a
     * @return
     */
    private static int findMaximumSubarraySum(int[] a) {
        int sum = 0;
        for (int value : a) {
            sum += value;
            if (value > sum) {
                sum = value;
            }
        }
        return sum;
    }
}

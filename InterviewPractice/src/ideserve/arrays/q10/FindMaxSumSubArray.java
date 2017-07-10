package ideserve.arrays.q10;

/**
 * http://www.ideserve.co.in/learn/maximum-average-subarray
 */
public class FindMaxSumSubArray {

    public static void main(String[] args) {
        findMaxSumSubArray(new int[]{11, -8, 16, -7, 24, -2, 3}, 3);
    }

    private static void findMaxSumSubArray(int[] a, int k) {

        int maxSum = Integer.MIN_VALUE;

        int prevSum = 0;
        for (int i = 0; i < k; i++) {
            prevSum += a[i];
        }

        if (prevSum > maxSum)
            maxSum = prevSum;

        int tempSum = 0;
        for (int i = k; i < a.length; i++) {
            tempSum = prevSum + a[i] - a[i - k];
            if (tempSum > maxSum)
                maxSum = tempSum;
            prevSum = tempSum;
        }

        System.out.println("Max sum of subarray: " + maxSum);
    }
}

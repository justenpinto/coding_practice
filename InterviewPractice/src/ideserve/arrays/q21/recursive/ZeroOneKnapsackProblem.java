package ideserve.arrays.q21.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.ideserve.co.in/learn/dynamic-programming-0-1-knapsack-problem
 */
public class ZeroOneKnapsackProblem {

    public static void main(String[] args) {
        int benefit = findMaximumBenefit(10, 0, new int[]{3,7,2,9}, new int[]{2,2,4,5});
        System.out.println(benefit);
    }

    /**
     * O(2^n) runtime
     * O(1) space
     *
     * @param w
     * @param n
     * @param val
     * @param weight
     * @return
     */
    private static int findMaximumBenefit(int w, int n, int[] val, int[] weight) {
        if (w == 0 || n == weight.length) {
            return 0;
        }

        if (weight[n] > w) {
            return findMaximumBenefit(w, n+1, val, weight);
        }

        return Math.max(findMaximumBenefit(w, n+1, val, weight),
                findMaximumBenefit(w - weight[n], n+1, val, weight) + val[n]);
    }
}

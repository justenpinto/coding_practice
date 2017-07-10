package ideserve.arrays.q11.recursive;

/**
 * http://www.ideserve.co.in/learn/set-partition-problem-recursion
 */
public class ValidEqualSumSets {

    public static void main(String[] args) {
        isValidSet(new int[]{15,5,15,20,45});
        isValidSet(new int[]{21,33,37,2});
    }

    /**
     * O(2^n) runtime
     * O(1) space
     * @param a
     */
    private static void isValidSet(int[] a) {
        int sum = 0;
        for (int v : a) {
            sum += v;
        }

        if (sum % 2 == 1) {
            System.out.println("Odd sum for entire array: false");
            return;
        }

        System.out.println(findSumN(a, sum/2, 0));

    }

    private static boolean findSumN(int[] a, int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (index == a.length) {
            return false;
        }

        return findSumN(a, sum, index + 1) || findSumN(a, sum - a[index], index + 1);
    }
}

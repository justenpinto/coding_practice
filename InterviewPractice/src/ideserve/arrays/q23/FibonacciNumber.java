package ideserve.arrays.q23;

/**
 * http://www.ideserve.co.in/learn/nth-fibonacci-number
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        int value = findFibonacciRecursive(10);
        System.out.println(value);

        value = findFibonacciDynamic(6);
        System.out.println(value);
        value = findFibonacciDynamic(10);
        System.out.println(value);
    }

    /**
     * O(2^n) runtime
     * O(1) space
     *
     * @param n
     * @return
     */
    private static int findFibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return findFibonacciRecursive(n - 1) + findFibonacciRecursive(n - 2);
    }

    /**
     * O(n) runtime
     * O(1) space
     *
     * @param n
     * @return
     */
    private static int findFibonacciDynamic(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;

        int value = 0;
        for (int i = 2; i < n; i++) {
            value = prev + prevPrev;
            prevPrev = prev;
            prev = value;
        }
        return value;
    }
}

package ideserve.arrays.q17.dynamic;

/**
 * http://www.ideserve.co.in/learn/minimum-number-of-coins-to-make-change
 */
public class MinimumNumberOfCoins {

    public static void main(String[] args) {
        makeChange(new int[]{25,10,5,1}, 52);
    }

    /**
     * O(n*c) runtime
     * O(n) space
     * @param coins
     * @param value
     */
    private static void makeChange(int[] coins, int value) {
        int[] dpArray = new int[value + 1];
        dpArray[0] = 0;

        int min = 0;
        for (int i = 1; i < dpArray.length; i++) {
            min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin) {
                    min = min(dpArray[i - coin], min);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dpArray[i] = min + 1;
            }
            else {
                dpArray[i] = Integer.MAX_VALUE;
            }
        }
        System.out.println("Minimum number: " + dpArray[value]);
    }

    private static int min(int a, int b) {
        return Math.min(a,b);
    }
}
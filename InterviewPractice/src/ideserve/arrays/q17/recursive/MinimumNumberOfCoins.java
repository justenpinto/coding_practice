package ideserve.arrays.q17.recursive;

public class MinimumNumberOfCoins {

    public static void main(String[] args) {
        System.out.println(makeChange(new int[]{25, 10, 5,1}, 58));
    }

    /**
     * O(n^v) runtime
     * O(1) space
     * @param coins
     * @param value
     */
    private static int makeChange(int[] coins, int value) {
        if (value == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (value >= coin) {
                min = min(min, makeChange(coins, value - coin) + 1);
            }
        }
        return min;
    }

    private static int min(int a, int b) {
        return Math.min(a,b);
    }
}
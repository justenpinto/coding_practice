package ideserve.arrays.q14.recursive;

/**
 * Created by justenpinto on 2017-07-09.
 */
public class TotalNumberOfWaysToMakeChange {

    public static void main(String[] args) {
        int ways = 0;
        int totalTime = 0;
        int n = 1000;
        for (int i = 0; i < n; i++) {
            long startTime = System.nanoTime();
            ways = makeChange(new int[]{20, 10, 5, 1}, 0, 50);
            totalTime += (System.nanoTime() - startTime);
        }
        System.out.println("Ways to make change: " + ways + ". Performance = " + (totalTime / n) / 1000000d + "ms");
    }

    private static int makeChange(int[] coins, int index, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0 || index >= coins.length) {
            return 0;
        }
        int count = 0;
        int ways = 0;
        while (amount - count * coins[index] >= 0) {
            ways += makeChange(coins, index + 1, amount - count++ * coins[index]);
        }
        return ways;
    }
}

package ideserve.arrays.q14.memo;

import java.util.HashMap;
import java.util.Map;

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
            Map<AmountCoins, Integer> memo = new HashMap<>();
            ways = makeChange(new int[]{20, 10, 5, 1}, 0, 50, memo);
            totalTime += (System.nanoTime() - startTime);
        }
        System.out.println("Ways to make change: " + ways + ". Performance = " + (totalTime / n) / 1000000d + "ms");
    }

    private static int makeChange(int[] coins, int index, int amount, Map<AmountCoins, Integer> memo) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0 || index >= coins.length) {
            return 0;
        }
        int count = 0;
        int ways = 0;
        int delta = amount - count * coins[index];
        AmountCoins temp = new AmountCoins(amount, coins[index]);
        if (memo.containsKey(temp)) {
            return memo.get(temp);
        }
        while (delta >= 0) {
            ways += makeChange(coins, index + 1, delta, memo);
            delta = amount - ++count * coins[index];
        }
        memo.put(temp, ways);
        return ways;
    }
}

class AmountCoins {
    private int amount;
    private int denom;

    public AmountCoins(int amount, int denom) {
        this.amount = amount;
        this.denom = denom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmountCoins that = (AmountCoins) o;

        if (amount != that.amount) return false;
        return denom == that.denom;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + denom;
        return result;
    }
}

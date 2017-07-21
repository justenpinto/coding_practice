package ideserve.arrays.q18.part2;

/**
 * http://www.ideserve.co.in/learn/buy-and-sell-stocks-part-two
 */
public class BuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(findBestProfit(new int[]{100,80,120,130,70,60,100,125}));
    }

    /**
     * O(n) runtime
     * O(1) space
     *
     * @param stockPrices
     * @return
     */
    private static int findBestProfit(int[] stockPrices) {
        int profit = 0;
        int accumulatedProfit = 0;
        int minimum = stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {
            profit = Math.max(stockPrices[i] - minimum, profit);
            if (stockPrices[i] < minimum) {
                accumulatedProfit += profit;
                profit = 0;
                minimum = stockPrices[i];
            }
        }
        accumulatedProfit += profit;
        return accumulatedProfit;
    }
}

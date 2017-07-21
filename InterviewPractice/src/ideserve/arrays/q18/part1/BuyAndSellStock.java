package ideserve.arrays.q18.part1;

/**
 * http://www.ideserve.co.in/learn/buy-and-sell-stock-part-one
 */
public class BuyAndSellStock {

    public static void main(String[] args) {
        int profit = findBestProfit(new int[]{100, 80, 120, 130, 70, 60, 100, 125});
        System.out.println("Profit: " + profit);
    }

    /**
     * O(n) runtime
     * O(1) space
     * @param stockPrices
     * @return
     */
    private static int findBestProfit(int[] stockPrices) {
        int profit = 0;
        int minimumPrice = stockPrices[0];
        for (int i = 1; i < stockPrices.length; i++) {
            profit = Math.max(profit, stockPrices[i] - minimumPrice);
            minimumPrice = Math.min(minimumPrice, stockPrices[i]);
        }
        return profit;
    }
}

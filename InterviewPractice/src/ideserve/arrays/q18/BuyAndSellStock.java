package ideserve.arrays.q18;

/**
 * Created by justenpinto on 2017-07-10.
 */
public class BuyAndSellStock {

    public static void main(String[] args) {
        int profit = findBestProfit(new int[]{100, 80, 120, 130, 70, 60, 100, 125});
        System.out.println("Profit: " + profit);
    }

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

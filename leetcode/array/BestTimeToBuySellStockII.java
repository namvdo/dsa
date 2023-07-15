package leetcode.array;

public class BestTimeToBuySellStockII {
    public int maxProfit(int[] prices) {
        int res = 0;
        int smallestSoFar = prices[0];
        int resSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < smallestSoFar) {
                smallestSoFar = prices[i];
            }
            if (prices[i] - smallestSoFar > resSoFar) {
                resSoFar = prices[i] - smallestSoFar;
                if (i == prices.length - 1) {
                    res += resSoFar;
                }
            } else {
                res += resSoFar;
                smallestSoFar = prices[i];
                resSoFar = 0;
            }
        }
        return res;
    }
}

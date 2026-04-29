class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int sell: prices) {
            if (buy > sell) {
                buy = sell;
            } else {
                profit = Math.max(profit, sell - buy);
            }
        }
         return profit;
    }
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buy = prices[0]
        var max = 0

        for(sell in prices) {
            if (buy < sell) {
                max = max(max, sell - buy)
            } else {
                buy = sell
            }
        }

        return max
    }
}

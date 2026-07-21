class Solution {
    fun maxProfit(prices: IntArray): Int {
        var dp1_buy = 0
        var dp1_sell = 0
        var dp2_buy = 0

        for(i in prices.lastIndex downTo 0) {
            val p = prices[i]
            val dp_buy = max(dp1_sell-p, dp1_buy)
            val dp_sell = max(dp2_buy+p, dp1_sell)

            dp2_buy = dp1_buy
            dp1_buy = dp_buy
            dp1_sell = dp_sell
        }

        return dp1_buy
    }
}

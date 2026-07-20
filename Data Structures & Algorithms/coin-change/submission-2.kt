class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount+1) { amount+1 }
        dp[0] = 0

        for(c in coins) {
            for(a in 1 .. amount) {
                if(a - c >= 0) {
                    dp[a] = min(dp[a], 1+ dp[a-c])
                }
            }
        }

        return if(dp[amount] > amount) -1 else dp[amount]
    }
}
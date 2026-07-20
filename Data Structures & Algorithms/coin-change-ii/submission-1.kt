class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1

        for(c in coins) {
            for(a in 1 .. amount) {
                if(a - c >= 0) {
                    dp[a] += dp[a - c] 
                }
            }
        }

        return dp[amount]
    }
}

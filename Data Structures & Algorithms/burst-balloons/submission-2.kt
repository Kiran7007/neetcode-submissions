class Solution {
    fun maxCoins(nums: IntArray): Int {
        val n = nums.size
        val newNums = intArrayOf(1) + nums + intArrayOf(1)

        val dp = Array(n + 2) { IntArray(n + 2) }

        for (l in n downTo 1) {
            for (r in l..n) {
                for (i in l..r) {
                    val coins = newNums[l - 1] * newNums[i] * newNums[r + 1]
                    dp[l][r] = maxOf(dp[l][r], coins + dp[l][i - 1] + dp[i + 1][r])
                }
            }
        }

        return dp[1][n]
    }
}
class Solution {
    fun numDistinct(s: String, t: String): Int {
        val m = s.length
        val n = t.length
        val dp = IntArray(n)

        for(i in m - 1 downTo 0) {
            var prev = 1
            for(j in n - 1 downTo 0) {
                val temp = dp[j]
                if (s[i] == t[j]) {
                    dp[j] += prev
                }
                prev = temp
            }
        }

        return dp[0]
    }
}

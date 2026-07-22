class Solution {
    fun numDistinct(s: String, t: String): Int {
        val m = s.length
        val n = t.length
        val dp = IntArray(n+1)

        dp[n] = 0

        for(i in m - 1 downTo 0) {
            var prev = 1
            for(j in n - 1 downTo 0) {
                var res = dp[j]
                if(s[i] == t[j]) {
                    res += prev
                }
                prev = dp[j]
                dp[j] = res
            }
        }

        return dp[0]
    }
}

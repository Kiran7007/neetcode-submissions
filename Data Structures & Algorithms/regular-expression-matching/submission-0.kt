class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val m  = s.length
        val n = p.length

        var dp = BooleanArray(n+1)
        dp[n] = true

        for(i in m downTo 0) {
            var dp1 = dp[n]
            dp[n] = (i == m)

            for(j in n-1 downTo 0) {
                val match = i < m && (s[i] == p[j] || p[j] == '.')
                var res = false

                if(j + 1 < n && p[j+1] == '*') {
                    res = dp[j+2]
                    if(match) {
                        res = res || dp[j]
                    }
                } else if(match) {
                    res = dp1
                }
                dp1 = dp[j]
                dp[j] = res
            }
        }

        return dp[0]
    }
}

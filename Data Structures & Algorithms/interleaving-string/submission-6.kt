class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        var s1 = s1
        var s2 = s2
        var m = s1.length
        var n = s2.length
        if (m + n != s3.length) {
            return false
        }
        if (n < m) {
            val temp = s1
            s1 = s2
            s2 = temp

            val temp1 = m
            m = n
            n = temp1
        }

        val dp = BooleanArray(n + 1)
        dp[n] = true
        for (i in m downTo 0) {
            var nextDp = (i == m)
            for (j in n downTo 0) {
                var res = nextDp
                if (j < n) res = false
                if (i < m && s1[i] == s3[i + j] && dp[j]) {
                    res = true
                }
                if (j < n && s2[j] == s3[i + j] && nextDp) {
                    res = true
                }
                dp[j] = res
                nextDp = dp[j]
            }
        }
        return dp[0]
    }
}
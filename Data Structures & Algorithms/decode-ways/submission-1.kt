class Solution {
    fun numDecodings(s: String): Int {
        val dp = hashMapOf(s.length to 1)

        fun dfs(s: String, i: Int): Int {
            if(i in dp) {
                return dp[i]!!
            }

            if (i == s.length) {
                return 1
            }
            if (s[i] == '0') {
                return 0
            }
            var res = dfs(s, i + 1)
            if (i < s.length - 1) {
                if (s[i] == '1' || (s[i] == '2' && s[i + 1] < '7')) {
                    res += dfs(s, i + 2)
                }
            }

            dp[i] = res
            return res
        }

        return dfs(s, 0)
    }
}

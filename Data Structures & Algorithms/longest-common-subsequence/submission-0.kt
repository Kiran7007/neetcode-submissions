class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }

        for(i in text1.length - 1 downTo 0) {
            for(j in text2.length-1 downTo 0) {
                dp[i][j] = if(text1[i] == text2[j]) {
                    1 + dp[i + 1][j + 1]
                } else {
                    max(dp[i+1][j], dp[i][j+1])
                }
            }
        }
        return dp[0][0]
    }
}

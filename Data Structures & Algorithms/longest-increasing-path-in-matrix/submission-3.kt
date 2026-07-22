class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val rows = matrix.size
        val cols = matrix[0].size
        val dp = Array(rows) { IntArray(cols) }

        fun dfs(r: Int, c: Int, prevVal: Int): Int {
            if (r < 0 || r >= rows || c < 0 || c >= cols ||
                matrix[r][c] <= prevVal) {
                return 0
            }
            if (dp[r][c] != 0) {
                return dp[r][c]
            }

            var res = 1
            res = maxOf(res, 1 + dfs(r + 1, c, matrix[r][c]))
            res = maxOf(res, 1 + dfs(r - 1, c, matrix[r][c]))
            res = maxOf(res, 1 + dfs(r, c + 1, matrix[r][c]))
            res = maxOf(res, 1 + dfs(r, c - 1, matrix[r][c]))
            dp[r][c] = res
            return res
        }

        var maxPath = 0
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                maxPath = maxOf(maxPath, dfs(r, c, -1))
            }
        }
        return maxPath
    }
}
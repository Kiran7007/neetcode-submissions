class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val directions = listOf(
            0 to 1, 0 to -1, -1 to 0, 1 to 0
        )

        val ROW = grid.size
        val COL = grid[0].size
        var count = 0

        fun dfs(r: Int, c: Int) {
            if(r < 0 || c < 0 || r >= ROW || c >= COL || grid[r][c] == '0') return

            grid[r][c] = '0'

            for((row, col) in directions) {
                dfs(r + row, c + col)
            }
        }


        repeat(ROW) { r ->
            repeat(COL) { c ->
                if(grid[r][c] == '1') {
                    dfs(r, c)
                    count++
                }
            }
        }

        return count
    }
}

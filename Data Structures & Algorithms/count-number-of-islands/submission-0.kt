class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )

        val ROW = grid.size
        val COL = grid[0].size
        var count = 0

        fun dfs(r: Int, c: Int) {
            if(r < 0 || c < 0 || r >= ROW || c >= COL || grid[r][c] == '0')
            return

            grid[r][c] = '0'
            for(dir in directions) {
                dfs(r + dir[0], c + dir[1])
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

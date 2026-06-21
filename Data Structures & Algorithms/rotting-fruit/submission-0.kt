class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val ROW = grid.size
        val COL = grid[0].size

        var fresh = 0
        var time = 0

        for (r in 0 until ROW) {
            for(c in 0 until COL) {
                if(grid[r][c] == 1) fresh++
            }
        }

        val directions = arrayOf(
            0 to 1,
            1 to 0,
            0 to -1,
            -1 to 0
        )

        while (fresh > 0) {
            var flag = false
            for(r in 0 until ROW) {
                for(c in 0 until COL) {
                    if(grid[r][c] == 2) {
                        for(d in directions) {
                            val row = r + d.first
                            val col = c + d.second

                            if(row in 0 until ROW && col in 0 until COL
                            && grid[row][col] == 1) {
                                grid[row][col] = 3
                                fresh--
                                flag = true
                            }
                        }
                    }
                }
            }

            if(!flag) return -1

            for(r in 0 until ROW) {
                for(c in 0 until COL) {
                    if(grid[r][c] == 3) grid[r][c] = 2
                }
            }
            time++
        }
        return time
    }
}

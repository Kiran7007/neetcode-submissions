class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val directions = arrayOf(
            intArrayOf(0,  1),
            intArrayOf(0,  -1),
            intArrayOf(1,  0),
            intArrayOf(-1,  0)
        )

        val row = grid.size
        val col = grid[0].size
        val hashSet = HashSet<Pair<Int, Int>>()

        fun dfs(r: Int, c: Int): Int {
            if(r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == 0 ||
            hashSet.contains(r to c)) return 0

            hashSet.add(r to c)

            return 1 + directions.sumOf { dir ->
                    dfs(r + dir[0], c + dir[1])
            }
        }

        var maxArea = 0
        repeat(row) { r ->
            repeat(col) { c ->
                maxArea = max(maxArea, dfs(r, c))
            }
        }

        return maxArea
    }
}

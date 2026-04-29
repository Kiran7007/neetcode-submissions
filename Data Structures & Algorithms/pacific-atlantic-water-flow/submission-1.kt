class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val ROW = heights.size
        val COL = heights[0].size
        val res = mutableListOf<List<Int>>()
        val pac = HashSet<Pair<Int, Int>>()
        val atl = HashSet<Pair<Int, Int>>()

        fun dfs(r: Int, c: Int, visited: HashSet<Pair<Int, Int>>, prevHeight: Int) {
            if(r < 0 || c < 0 || r == ROW || c == COL || Pair(r, c) in visited || heights[r][c] < prevHeight)
            return

            visited.add(Pair(r, c))
            dfs(r+1, c, visited, heights[r][c])
            dfs(r-1, c, visited, heights[r][c])
            dfs(r, c+1, visited, heights[r][c])
            dfs(r, c-1, visited, heights[r][c])
        }


        repeat(COL) { c ->
            dfs(0, c, pac, heights[0][c])
            dfs(ROW - 1, c, atl, heights[ROW - 1][c])
        }

        repeat(ROW) { r ->
            dfs(r, 0, pac, heights[r][0])
            dfs(r, COL - 1, atl, heights[r][COL - 1])
        }

        repeat(ROW) { r ->
            repeat(COL) { c ->
                if(Pair(r, c) in pac && Pair(r, c) in atl) {
                    res.add(listOf(r, c))
                }
            }
        }

        return res.toList()
    }
}

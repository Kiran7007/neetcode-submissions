class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val ROW = grid.size
        val COL = grid[0].size
        val queue = LinkedList<Pair<Int, Int>>()

        repeat(ROW) { r ->
            repeat(COL) { c ->
                if(grid[r][c] == 0) {
                    queue.add(Pair(r, c))
                }
            }
        }

        if(queue.isEmpty()) return

        val directions = listOf(
            0 to 1,
            0 to -1,
            1 to 0,
            -1 to 0
        )

        while(queue.isNotEmpty()) {
            val (r, c) = queue.poll()
            for(dir in directions) {
                val row = r + dir.first
                val col = c + dir.second

                if(row !in 0 until ROW || col !in 0 until COL || grid[row][col] != Int.MAX_VALUE) continue

                queue.add(row to col)
                grid[row][col] = grid[r][c] + 1
            }
        }
    }
}

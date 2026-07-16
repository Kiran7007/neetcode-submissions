class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        val N = grid.size
        val directions = listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

        val minHeap = PriorityQueue(compareBy<Pair<Int, Pair<Int, Int>>> { it.first })
        minHeap.offer(Pair(grid[0][0], Pair(0, 0)))

        val visited = HashSet<Pair<Int, Int>>()

        while (minHeap.isNotEmpty()) {
            val (t, pos) = minHeap.poll()
            val (r, c) = pos

            visited.add(Pair(r, c))

            if (r == N - 1 && c == N - 1) return t

            for ((dr, dc) in directions) {
                val neiR = r + dr
                val neiC = c + dc
                if (neiR !in 0 until N || neiC !in 0 until N || Pair(neiR, neiC) in visited) {
                    continue
                }

                minHeap.offer(Pair(maxOf(t, grid[neiR][neiC]), Pair(neiR, neiC)))
            }
        }

        return -1
    }
}

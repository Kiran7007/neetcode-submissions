class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val rows = matrix.size
        val cols = matrix[0].size

        val inDegree = Array(rows) { IntArray(cols) }
        val directions = listOf(0 to 1, 0 to -1, -1 to 0, 1 to 0)

        repeat(rows) { r ->
            repeat(cols) { c ->
                for((row, col) in directions) {
                    val nr = r + row
                    val nc = c + col
                    if(nr in 0 until rows && nc in 0 until cols &&
                        matrix[nr][nc] < matrix[r][c]) {
                        inDegree[r][c]++
                    }
                }
            }
        }

        val queue = LinkedList<IntArray>()

        repeat(rows) { r ->
            repeat(cols) { c ->
                if(inDegree[r][c] == 0) {
                    queue.offer(intArrayOf(r, c))
                }
            }
        }

        var res = 0

        while(queue.isNotEmpty()) {
            repeat(queue.size) {
                val (r, c) = queue.poll()
                for((row, col) in directions) {
                    val nr = r + row
                    val nc = c + col
                    if(nr in 0 until rows && nc in 0 until cols &&
                        matrix[nr][nc] > matrix[r][c]) {
                        if(--inDegree[nr][nc] == 0) {
                            queue.offer(intArrayOf(nr, nc))
                        }
                    }
                }
            }
            res++
        }

        return res
    }
}

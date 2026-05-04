class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val cols = matrix[0].size

        var l = 0
        var r = rows * cols - 1

        while(l <= r) {
            val mid = l + (r-l)/2
            val row = mid / cols
            val col = mid % cols

            when {
                matrix[row][col] < target -> l = mid + 1
                matrix[row][col] > target -> r = mid - 1
                matrix[row][col] == target -> return true
                else -> false
            }
        }

        return false
    }
}

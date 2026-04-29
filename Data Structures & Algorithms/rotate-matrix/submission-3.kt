class Solution {
    fun rotate(matrix: Array<IntArray>) {
        var left = 0
        var right = matrix.lastIndex

        while(left < right) {
            for(i in 0 until right-left) {
                val top = left
                val bottom = right

                val topLeft = matrix[top][left + i]
                matrix[top][left + i] = matrix[bottom - i][left]
                matrix[bottom - i][left] = matrix[bottom][right - i]
                matrix[bottom][right - i] = matrix[top + i][right]
                matrix[top + i][right] = topLeft
            }
            right--
            left++
        }
    }
}

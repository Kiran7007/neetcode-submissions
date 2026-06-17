class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if(matrix.isEmpty() || matrix[0].isEmpty()) return emptyList()

        var left = 0
        var top = 0
        var right = matrix[0].lastIndex
        var bottom = matrix.lastIndex
        val res = mutableListOf<Int>()

        while(left <= right && top <= bottom) {
            for(i in left..right) {
                res.add(matrix[top][i])
            }
            top++

            for(i in top..bottom) {
                res.add(matrix[i][right])
            }
            right--

            if (top <= bottom) {
                for(i in right downTo left) {
                    res.add(matrix[bottom][i])
                }
            }
            bottom--

            if (left <= right){
                for(i in bottom downTo top) {
                    res.add(matrix[i][left])
                }
            }
            left++
        }

        return res
    }
}

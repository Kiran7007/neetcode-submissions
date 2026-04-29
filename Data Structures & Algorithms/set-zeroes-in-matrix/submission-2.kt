class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val ROW = matrix.size
        val COL = matrix[0].size
        var rowZero = false

        repeat(ROW) { r ->
            repeat(COL) { c ->
                if(matrix[r][c] == 0) {
                    matrix[0][c] = 0
                    if(r > 0) {
                        matrix[r][0] = 0
                    } else {
                        rowZero = true
                    }
                }
            }
        }

        for(r in 1 until ROW) {
            for(c in 1 until COL) {
                if(matrix[0][c] == 0 || matrix[r][0] == 0) matrix[r][c] = 0
            }
        }

        if(matrix[0][0] == 0) {
            for(r in 0 until ROW) {
                matrix[r][0] = 0
            }
        }

        if(rowZero) {
            for(c in 0 until COL) {
                matrix[0][c] = 0
            }
        }
    }
}

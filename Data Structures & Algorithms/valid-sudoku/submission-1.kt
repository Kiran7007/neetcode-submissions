class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = IntArray(9)
        val cols = IntArray(9)
        val squares = IntArray(9)

        for (r in 0 until 9) {
            for (c in 0 until 9) {
                if (board[r][c] == '.') continue

                val value = board[r][c] - '1'
                val bit = 1 shl value
                val squareIdx = (r / 3) * 3 + (c / 3)

                if ((rows[r] and bit) != 0 || (cols[c] and bit) != 0 ||
                    (squares[squareIdx] and bit) != 0) {
                    return false
                }

                rows[r] = rows[r] or bit
                cols[c] = cols[c] or bit
                squares[squareIdx] = squares[squareIdx] or bit
            }
        }

        return true
    }
}
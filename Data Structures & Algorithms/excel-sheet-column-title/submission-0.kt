class Solution {
    fun convertToTitle(columnNumber: Int): String {
        if(columnNumber == 0) return ""
        val n = columnNumber - 1
        return convertToTitle(n / 26) + ('A' + n % 26).toChar()
    }
}

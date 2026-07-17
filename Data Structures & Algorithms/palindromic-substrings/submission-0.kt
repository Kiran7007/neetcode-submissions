class Solution {
    fun countSubstrings(s: String): Int {
        var res = 0

        for(i in s.indices) {
            res += countPalindrom(s, i, i)
            res += countPalindrom(s, i, i+1)
        }

        return res
    }

    private fun countPalindrom(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        var res = 0

        while(l >= 0 && r < s.length && s[l] == s[r]) {
            res++
            l--
            r++
        }

        return res
    }
}

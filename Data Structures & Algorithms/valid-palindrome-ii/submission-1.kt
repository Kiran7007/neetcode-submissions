class Solution {
    fun validPalindrome(s: String): Boolean {

        fun isPalindrome(left: Int, right: Int): Boolean {
            var start = left
            var end = right

            while(start < end) {
                if(s[start] != s[end]) return false
                start++
                end--
            }
            return true
        }

        var l = 0
        var r = s.lastIndex
        while(l < r) {
            if(s[l] != s[r]) {
                return isPalindrome(l+1, r) || isPalindrome(l, r-1)
            }
            l++
            r--
        }
        return true
    }
}

class Solution {
    fun validPalindrome(s: String): Boolean {

        fun isPalindrome(str: String): Boolean {
            var start = 0
            var end = str.lastIndex

            while(start < end) {
                if(str[start] != str[end]) return false
                start++
                end--
            }
            return true
        }

        var l = 0
        var r = s.lastIndex
        while(l < r) {
            if(s[l] != s[r]) {
                val skipL = s.substring(l+1, r+1)
                val skipR = s.substring(l, r)

                return isPalindrome(skipL) || isPalindrome(skipR)
            }
            l++
            r--
        }
        return true
    }
}

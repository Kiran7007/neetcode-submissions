class Solution {
    fun longestPalindrome(s: String): String {
        var resInx = 0
        var resLen = 0

        for(i in s.indices) {
            var l = i
            var r = i

            while(l >= 0 && r < s.length && s[l] == s[r]) {
                if(r - l + 1 > resLen) {
                    resInx = l
                    resLen = r - l + 1
                }

                l--
                r++
            }

            l = i
            r = i+1

            while(l >= 0 && r < s.length && s[l] == s[r]) {
                if(r - l + 1 > resLen) {
                    resInx = l
                    resLen = r - l + 1
                }

                l--
                r++
            }
        }

        return s.substring(resInx, resInx + resLen)
    }
}

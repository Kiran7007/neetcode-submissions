class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val hashMap = HashMap<Char, Int>()
        var l = 0
        var res = 0
        
        for(r in s.indices) {
            if(s[r] in hashMap) {
                l = maxOf(hashMap[s[r]]!! + 1, l)
            }
            hashMap[s[r]] = r
            res = max(res, r - l + 1)
        }

        return res
    }
}

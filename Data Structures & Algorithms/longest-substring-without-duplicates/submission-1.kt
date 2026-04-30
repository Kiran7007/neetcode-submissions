class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val hashSet = HashSet<Char>()
        var l = 0
        var res = 0
        
        for(r in s.indices) {
            while(s[r] in hashSet) {
                hashSet.remove(s[l])
                l++
            }
            hashSet.add(s[r])
            res = max(res, hashSet.size)
        }

        return res
    }
}

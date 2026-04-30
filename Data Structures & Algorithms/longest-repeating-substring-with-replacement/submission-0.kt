class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var count = k
        var map = HashMap<Char, Int>()
        var l = 0
        var maxF = 0
        var res = 0

        for(r in s.indices) {
            map[s[r]] = map.getOrPut(s[r]) { 0 } + 1
            maxF = max(maxF, map[s[r]]!!)

            while (r - l + 1 - maxF > k) {
                map[s[l]] = map[s[l]]!! - 1
                l++
            }

            res = max(res, r-l+1)
        } 

        return res
    }
}

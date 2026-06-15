class Solution {
    fun partitionLabels(s: String): List<Int> {
        val res = mutableListOf<Int>()
        val map = HashMap<Char, Int>()
        for((i, c) in s.withIndex()) {
            map[c] = i
        }

        var start = 0
        var end = 0

        for(i in s.indices) {
            start++
            end = max(end, map.getOrDefault(s[i], 0))
            
            if(i == end) {
                res.add(start)
                start = 0
            }
        }
        return res
    }
}

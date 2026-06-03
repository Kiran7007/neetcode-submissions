class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        
        val map = HashMap<Char, Int>()

        for(c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        for(c in t) {
            if(!map.contains(c) || map[c]!! == 0) {
                return false
            }

            map[c] = map.getOrDefault(c, 0) - 1
        }

        return true
    }
}

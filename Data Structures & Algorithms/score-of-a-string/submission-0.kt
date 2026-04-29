class Solution {
    fun scoreOfString(s: String): Int {
        var count = 0
        for(i in 1 until s.length) {
            count += Math.abs(s.get(i) - s.get(i-1))
        }
        return count
    }
}

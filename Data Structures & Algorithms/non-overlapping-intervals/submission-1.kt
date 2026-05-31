class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[1] }
        var res = 0
        var prev = intervals[0][1]

        for((start, end) in intervals.slice(1 until intervals.size)) {
            if(prev > start) {
                res++
            } else  {
                prev = end
            }
        }

        return res
    }
}

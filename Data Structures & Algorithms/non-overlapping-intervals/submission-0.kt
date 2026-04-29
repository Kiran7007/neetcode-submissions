class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[1] }

        var res = 0
        var prev = intervals[0][1]

        for(i in 1 .. intervals.lastIndex) {
            if(prev > intervals[i][0]) {
                res++
            } else {
                prev = intervals[i][1]
            }
        }
        return res
    }
}

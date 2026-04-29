class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val res = mutableListOf<IntArray>()

        for(interval in intervals) {
            if(newInterval[1] < interval[0]) {
                res.add(newInterval)
                return (res + intervals.sliceArray(intervals.indexOf(interval) until intervals.size)).toTypedArray()
            } else if (newInterval[0] > interval[1]) {
                res.add(interval)
            } else {
                newInterval[0] = min(newInterval[0], interval[0])
                newInterval[1] = max(newInterval[1], interval[1])
            }
        }
        res.add(newInterval)
        return res.toTypedArray()
    }
}

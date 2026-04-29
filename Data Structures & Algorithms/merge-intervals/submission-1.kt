class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        var maxVal = Int.MIN_VALUE
        for (interval in intervals) {
            maxVal = maxOf(maxVal, interval[0])
        }

        val mp = IntArray(maxVal + 1)
        for (interval in intervals) {
            val (start, end) = interval
            mp[start] = maxOf(mp[start], end + 1)
        }

        val res = mutableListOf<IntArray>()
        var have = -1
        var intervalStart = -1
        for (i in mp.indices) {
            if (mp[i] != 0) {
                if (intervalStart == -1) {
                    intervalStart = i
                }
                have = maxOf(mp[i] - 1, have)
            }
            if (have == i) {
                res.add(intArrayOf(intervalStart, have))
                have = -1
                intervalStart = -1
            }
        }

        if (intervalStart != -1) {
            res.add(intArrayOf(intervalStart, have))
        }

        return res.toTypedArray()
    }
}

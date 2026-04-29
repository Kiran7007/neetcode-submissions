class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        var maxStart = 0

        for((start, end) in intervals) {
            maxStart = max(maxStart, start)
        }

        val mp = IntArray(maxStart + 1)
        for((start, end) in intervals) {
            mp[start] = max(mp[start], end + 1)
        }

        val res = mutableListOf<IntArray>()
        var have = -1
        var intervalStart = -1

        for(i in mp.indices) {
            if (mp[i] != 0) {
                if(intervalStart == -1) {
                    intervalStart = i
                }
                have = maxOf(mp[i] - 1, have)
            }

            if(have == i) {
                res.add(intArrayOf(intervalStart, have))
                have = -1
                intervalStart = -1
            }
        }

        if(intervalStart != -1) {
            res.add(intArrayOf(intervalStart, have))
        }

        return res.toTypedArray()
    }
}

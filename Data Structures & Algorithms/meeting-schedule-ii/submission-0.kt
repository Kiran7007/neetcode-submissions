/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val map = HashMap<Int, Int>()

        for(interval in intervals) {
            map[interval.start] = map.getOrPut(interval.start) { 0 } + 1
            map[interval.end] = map.getOrPut(interval.end) { 0 } - 1
        }

        val keys = map.keys.sorted()
        var prev = 0
        var res = 0

        for(k in keys) {
            prev += map[k]!!
            res = maxOf(res, prev)
        }

        return res
    }
}

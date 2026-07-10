/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val sorted = intervals.sortedBy { it.start }

        val minHeap = PriorityQueue<Int>()
        for(interval  in sorted) {
            if(minHeap.isNotEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll()
            }
            minHeap.add(interval.end)
        }

        return minHeap.size
    }
}

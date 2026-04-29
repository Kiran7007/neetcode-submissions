class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it. second })
        val map = HashMap<Int, Int>()

        for(n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1
        }

        for((key, v) in map.entries) {
            queue.add(Pair(key, v))
            if (queue.size > k) {
                queue.poll()
            }
        }
        return queue.map{ it.first }.toIntArray()
    }
}

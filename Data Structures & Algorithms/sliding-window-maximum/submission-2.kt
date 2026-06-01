class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val res = mutableListOf<Int>()
        val queue = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.first })

        for((i, n) in nums.withIndex()) {
            queue.add(Pair(n, i))
            if(i >= k-1) {
                while(queue.peek().second <= i-k) {
                    queue.poll()
                }

                res.add(queue.peek().first)
            }
        }

        return res.toIntArray()
    }
}

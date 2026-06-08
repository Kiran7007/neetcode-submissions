class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue<Int>()

        for(s in stones) {
            queue.offer(-s) 
        }

        while(queue.size > 1) {
            val first = queue.poll()
            val second = queue.poll()

            if (second > first) {
                queue.offer(first-second)
            }
        }

        queue.offer(0)
        return Math.abs(queue.peek())
    }
}

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>()

        for(n in nums) {
            queue.offer(n)
            if(queue.size > k) {
                queue.poll()
            }
        }

        return queue.peek()
    }
}

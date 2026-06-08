class KthLargest(val k: Int, nums: IntArray) {

    val queue = PriorityQueue<Int>()

    init {
        nums.forEach {
            queue.offer(it)
        }

        while(queue.size > k) {
            queue.poll()
        }
    }

    fun add(`val`: Int): Int {
        queue.offer(`val`)
        if(queue.size > k) {
            queue.poll()
        }
        return queue.peek()
    }
}

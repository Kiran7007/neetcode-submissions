class KthLargest(val k: Int, nums: IntArray) {

    val queue = PriorityQueue<Int>()

    init {
        nums.forEach {
            add(it)
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

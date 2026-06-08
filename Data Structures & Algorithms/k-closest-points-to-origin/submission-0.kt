class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val queue = PriorityQueue<IntArray> { a, b ->
            ((b[0] * b[0]) + (b[1] * b[1])) - ((a[0] * a[0]) + (a[1] * a[1]))
        }

        for(n in points) {
            queue.offer(n)
            if(queue.size > k) {
                queue.poll()
            }
        }

        return Array(k) { queue.poll() }
    }
}

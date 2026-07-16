class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val prices = IntArray(n) { Int.MAX_VALUE }
        prices[src] = 0

        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (flight in flights) {
            val (from, to, cost) = flight
            adj[from].add(Pair(to, cost))
        }

        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        q.offer(Triple(0, src, 0))

        while (q.isNotEmpty()) {
            val (cst, node, stops) = q.poll()
            if (stops > k) continue

            for ((nei, w) in adj[node]) {
                val nextCost = cst + w
                if (nextCost < prices[nei]) {
                    prices[nei] = nextCost
                    q.offer(Triple(nextCost, nei, stops + 1))
                }
            }
        }

        return if (prices[dst] == Int.MAX_VALUE) -1 else prices[dst]
    }
}
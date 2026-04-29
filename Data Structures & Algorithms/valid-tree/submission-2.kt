class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if(edges.size > n - 1) return false

        val adj = Array(n) { mutableListOf<Int>()}

        for((s, d) in edges) {
            adj[s].add(d)
            adj[d].add(s)
        }

        val visited = mutableSetOf<Int>()
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.offer(Pair(0, -1))
        visited.add(0)

        while(queue.isNotEmpty()) {
            val (node, parent) = queue.poll()

            for(nei in adj[node]!!) {
                if(nei == parent) continue
                if(nei in visited) return false
                visited.add(nei)
                queue.add(nei to node)
            }
        }
        return visited.size == n
    }
}

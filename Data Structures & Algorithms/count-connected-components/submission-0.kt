class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val adj = Array(n) { mutableListOf<Int>() }

        for((source, destination) in edges) {
            adj[source].add(destination)
            adj[destination].add(source)
        }

        val visited = BooleanArray(n)

        fun bfs(node: Int) {
            val queue = ArrayDeque<Int>()
            queue.add(node)

            while(queue.isNotEmpty()) {
                val curr = queue.poll()

                for(nei in adj[curr]) {
                    if(!visited[nei]) {
                        visited[nei] = true
                        queue.add(nei)
                    }
                }
            }
        }

        var res = 0
        repeat(n) { node ->
            if(!visited[node]) {
                bfs(node)
                res++
            } 
        }

        return res
    }
}

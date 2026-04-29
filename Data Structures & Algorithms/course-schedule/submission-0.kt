class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val inDegree = IntArray(numCourses)
        val adj = Array(numCourses) { mutableListOf<Int>() }

        for((s, d) in prerequisites) {
            inDegree[d]++
            adj[s].add(d)
        }

        val queue = ArrayDeque<Int>()

        repeat(numCourses) { n ->
            if(inDegree[n] ==  0) {
                queue.add(n)
            }
        }

        var finish = 0

        while(queue.isNotEmpty()) {
            val s = queue.poll()
            finish++

            for(nei in adj[s]) {
                inDegree[nei]--
                if(inDegree[nei] == 0) {
                    queue.add(nei)
                }
            }
        }

        return finish == numCourses
    }
}

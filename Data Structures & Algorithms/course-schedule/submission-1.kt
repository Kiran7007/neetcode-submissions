class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val preMap = HashMap<Int, MutableList<Int>>()

        for((crs, pre) in prerequisites) {
            preMap.getOrPut(crs) { mutableListOf() }.add(pre)
        }

        val visited = HashSet<Int>()

        fun dfs(crs: Int): Boolean {
            if(crs in visited) return false
            if(preMap[crs].isNullOrEmpty()) return true

            visited.add(crs)
            for(c in preMap[crs]!!) {
                if(!dfs(c)) return false
            }
            visited.remove(crs)
            preMap[crs] = mutableListOf()
            return true
        }

        for(c in 0 until numCourses) {
            if(!dfs(c)) return false
        }

        return true
    }
}

class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val res = mutableListOf<String>()
        val map = HashMap<String, MutableList<String>>()

        tickets
        .sortedWith(compareBy({it[0]}, {it[1]}))
        .reversed()
        .forEach { item ->
            map.getOrPut(item[0]) { mutableListOf<String>() }.add(item[1])
        }

        fun dfs(src: String) {
            while(map[src]?.isNotEmpty() == true) {
                val dst = map[src]!!.removeLast()
                dfs(dst)
            }
            res.add(src)
        }

        dfs("JFK")
        return res.reversed()
    }
}

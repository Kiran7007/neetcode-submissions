class TimeMap() {
    val map = HashMap<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val list = map.getOrPut(key) { mutableListOf() }
        list.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        var res = ""
        if(!map.containsKey(key)) return res
        val values = map[key]!!

        var l = 0
        var r = values.lastIndex
        

        while(l <= r) {
            val m = (r + l) / 2
            if(values[m].first <= timestamp) {
                res = values[m].second
                l = m + 1
            } else {
                r = m - 1
            }
        }
        return res
    }
}

class MyHashMap() {

    private val data = IntArray(1000001) { -1 }

    fun put(key: Int, value: Int) {
        data[key] = value
    }

    fun get(key: Int): Int {
        return data[key]
    }

    fun remove(key: Int) {
        data[key] = -1
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */

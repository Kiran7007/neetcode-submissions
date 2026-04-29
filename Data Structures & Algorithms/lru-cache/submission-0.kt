class LRUCache(capacity: Int) {
    private val capacity = capacity

    data class Node (
        val key: Int,
        val value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    val cache = mutableMapOf<Int, Node>()
    val left = Node(0, 0)
    val right = Node(0, 0)

    init {
        left.next = right
        right.prev = left
    }

    private fun insert(node: Node) {
        val prev = right.prev
        prev?.next = node
        node.prev = prev
        node.next = right
        right.prev = node
    }

    private fun remove(node: Node) {
        val next = node.next
        val prev = node.prev
        prev?.next = next
        next?.prev = prev
    }

    fun get(key: Int): Int {
        return cache[key]?.let { node ->
            remove(node)
            insert(node)
            node.value
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        cache[key]?.let { node ->
            remove(node)
            cache.remove(key)
        }

        val newNode = Node(key, value)
        insert(newNode)
        cache[key] = newNode

        if(cache.size > capacity) {
            left.next?.let { node ->
                remove(node)
                cache.remove(node.key)
            }
        }
    }
}

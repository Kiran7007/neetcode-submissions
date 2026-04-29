class TrieNode {
    val children = HashMap<Char, TrieNode>()
    var endOfWord = false
}

class PrefixTree {

    private val root = TrieNode()

    fun insert(word: String) {
        var curr = root

        for(c in word) {
            curr.children.putIfAbsent(c, TrieNode())
            curr = curr.children[c]!!
        }
        curr.endOfWord = true
    }

    fun search(word: String): Boolean {
        var curr = root
        for(c in word) {
            if(c !in curr.children) return false
            curr = curr.children[c]!!
        }
        return curr.endOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var curr = root
        for(c in prefix) {
            if(c !in curr.children) return false
            curr = curr.children[c]!!
        }
        return true
    }
}

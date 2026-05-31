
class TriNode {
    val child = HashMap<Char, TriNode>()
    var count = 0
} 

class PrefixTree {
    val root = TriNode()

    fun add(word: String) {
        var curr = root

        for(c in word) {
            curr.child.putIfAbsent(c, TriNode())
            curr = curr.child[c]!!
            curr.count++
        }
    }

    fun count(word: String): Int {
        var curr = root

        for(c in word) {
            curr.child.putIfAbsent(c, TriNode())
            curr = curr.child[c]!!
        }
        return curr.count
    }
}

class Solution {
    val tree = PrefixTree()
    fun prefixCount(words: Array<String>, pref: String): Int {
        for(w in words) {
            tree.add(w)
        }
        return tree.count(pref)
    }
}

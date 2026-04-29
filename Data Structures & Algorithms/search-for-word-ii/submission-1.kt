class TrieNode {
    val child = HashMap<Char, TrieNode>()
    var endOfWord = false

    fun addWord(word: String) {
        var curr = this
        for(c in word) {
            curr.child.putIfAbsent(c, TrieNode())
            curr = curr.child[c]!!
        }
        curr.endOfWord = true
    }
}

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()

        for(word in words) {
            root.addWord(word)
        }

        val ROW = board.size
        val COL = board[0].size

        val visited = HashSet<Pair<Int, Int>>()
        val res = HashSet<String>()

        fun dfs(r: Int, c: Int, node: TrieNode, word: String) {
            if (r < 0 || c < 0 || r >= ROW || c >= COL ||
               (r to c) in visited || board[r][c] !in node.child) {
                return
            }

            visited.add(Pair(r, c))
            val newNode = node.child[board[r][c]]!!
            val newWord = word + board[r][c]

            if(newNode.endOfWord) {
                res.add(newWord)
            }

            dfs(r + 1, c, newNode, newWord)
            dfs(r - 1, c, newNode, newWord)
            dfs(r, c + 1, newNode, newWord)
            dfs(r, c - 1, newNode, newWord)

            visited.remove(Pair(r, c))
        }

        repeat(ROW) { r ->
            repeat(COL) { c ->
                dfs(r, c, root, "")
            }
        }

        return res.toList()
    }
}

class Solution {
    fun foreignDictionary(words: Array<String>): String {
        val adj = HashMap<Char, HashSet<Char>>()
        for (w in words) {
            for (c in w) {
                adj.putIfAbsent(c, hashSetOf())
            }
        }

        for (i in 0 until words.size - 1) {
            val w1 = words[i]
            val w2 = words[i + 1]
            val minLen = minOf(w1.length, w2.length)
            if (w1.length > w2.length &&
                w1.substring(0, minLen) == w2.substring(0, minLen)) {
                return ""
            }
            for (j in 0 until minLen) {
                if (w1[j] != w2[j]) {
                    adj[w1[j]]?.add(w2[j])
                    break
                }
            }
        }

        val visited = HashMap<Char, Boolean>()
        val res = mutableListOf<Char>()

        fun dfs(char: Char): Boolean {
            if (char in visited) {
                return visited[char]!!
            }

            visited[char] = true

            for (neighChar in adj[char] ?: emptySet()) {
                if (dfs(neighChar)) {
                    return true
                }
            }

            visited[char] = false
            res.add(char)
            return false
        }

        for (char in adj.keys) {
            if (dfs(char)) {
                return ""
            }
        }

        return res.reversed().joinToString("")
    }
}
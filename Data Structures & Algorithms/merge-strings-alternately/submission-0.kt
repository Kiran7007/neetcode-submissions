class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var i = 0
        var j = 0
        var res = ""

        while(i < word1.length && j < word2.length) {
            res = res + word1[i] + word2[j]
            i++
            j++
        }

        if(i < word1.length) res += word1.substring(i, word1.length)
        if(j < word2.length) res += word2.substring(j, word2.length)

        return res
    }
}

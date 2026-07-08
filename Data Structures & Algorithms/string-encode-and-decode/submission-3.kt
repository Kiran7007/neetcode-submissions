class Solution {

    fun encode(strs: List<String>): String {
        return strs.map {
            it.length.toString() + "#" + it
        }.joinToString("")
    }

    fun decode(str: String): List<String> {
        var i = 0
        val res = mutableListOf<String>()

        while(i < str.length) {
            var j = i

            while(str[j] != '#') {
                j++
            }

            val length = str.substring(i, j).toInt()

            i = j+1
            
            res.add(str.substring(i, i+length))
            i = i+length
        }

        return res
    }
}

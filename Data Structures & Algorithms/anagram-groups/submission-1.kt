class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        for(s in strs) {
            val key = s.toCharArray().sorted().joinToString()
            map.getOrPut(key) { mutableListOf<String>()}.add(s)
        }

        return map.values.toList()
    }
}

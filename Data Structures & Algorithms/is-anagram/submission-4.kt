class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length)  return false

        val arr = IntArray(26)

        for(c in s) {
            arr[c - 'a'] = arr[c - 'a'] + 1
        }

        for(c in t) {
            if(arr[c - 'a'] == 0) return false

            arr[c - 'a'] = arr[c - 'a'] - 1
        }

        return true
    }
}

class Solution {
    fun minWindow(s: String, t: String): String {
        val count = HashMap<Char, Int>()
        val window = HashMap<Char, Int>()

        for(c in t) {
            count[c] = count.getOrDefault(c, 0) + 1
        }

        var have = 0
        var need = count.size
        var l = 0
        var resLen = Int.MAX_VALUE
        var res = Pair(-1, -1)

        for((r, c) in s.withIndex()) {
            window[c] = window.getOrDefault(c, 0) + 1

            if(c in count && count[c]!! == window[c]!!) {
                have++
            }

            while(need == have) {
                if(r - l + 1 < resLen) {
                    resLen = r - l + 1
                    res = Pair(l , r)
                }

                window[s[l]] = window.getOrDefault(s[l], 0) - 1

                if(s[l] in count && window[s[l]]!! < count[s[l]]!!) {
                    have--
                }
                l++
            }
        }

        return if(resLen == Int.MAX_VALUE) "" else s.substring(res.first, res.second + 1)
    }
}

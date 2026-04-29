class Solution {
    fun maxDepth(s: String): Int {
        var res = 0
        var curr = 0

        for(c in s) {
            if(c == '(') curr++
            else if(c == ')') curr--

            res = maxOf(res, curr)
        }

        return res
    }
}

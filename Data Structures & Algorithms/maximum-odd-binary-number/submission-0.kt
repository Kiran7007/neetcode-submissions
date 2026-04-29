class Solution {
    fun maximumOddBinaryNumber(s: String): String {
        var count = 0
        var res = StringBuilder()
        for(c in s) {
            if(c == '1') count++
        }

        for(i in 0 until s.lastIndex) {
            if(count == 1) 
                res.append('0')
            else {
                res.append('1')
                count--
            }
        }
        res.append('1')
        return res.toString()
    }
}

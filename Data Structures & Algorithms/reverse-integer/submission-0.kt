class Solution {
    fun reverse(x: Int): Int {
        var num = x
        var res = 0
        while (num != 0) {
            val digit = (num % 10).toInt()
            num /= 10

            if(res > Int.MAX_VALUE/10 || res == Int.MAX_VALUE/10 && digit > Int.MAX_VALUE % 10) return 0
            if(res < Int.MIN_VALUE/10 || res == Int.MIN_VALUE/10 && digit < Int.MIN_VALUE % 10) return 0
            
            res = res * 10 + digit
        }
        return res
    }
}

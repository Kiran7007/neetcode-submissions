class Solution {
    fun myPow(x: Double, n: Int): Double {
        var num = x
        var res = 1.0

        if(num == 0.0) {
            return 0.0
        }

        if(n == 0) {
            return 1.0
        }

        var power = Math.abs(n.toLong())

        while(power > 0) {
            if (power and 1 != 0L) {
                res *= num
            }
            num *= num
            power = power shr 1
        }

        return if(n >= 0) res else 1.0 / res
    }
}

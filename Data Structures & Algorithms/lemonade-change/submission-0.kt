class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        var five = 0
        var ten = 0
        for(b in bills) {
            when {
                b == 5 -> five++
                b == 10 -> {
                    five--
                    ten++
                }
                ten > 0 -> {
                    five--
                    ten--
                }
                else -> five -= 3
            }
            if(five < 0) return false
        }

        return true
    }
}

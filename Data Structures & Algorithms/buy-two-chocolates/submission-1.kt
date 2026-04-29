class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {
        var min1 = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE

        for(p in prices) {
            when {
                p < min1 -> {
                    min2 = min1
                    min1 = p
                }
                p < min2 -> min2 = p
            }
        }
        return if(min1 + min2 > money) money else money - (min1 + min2)
    }
}

class Solution {
    fun climbStairs(n: Int): Int {
        var one = 1
        var two = 1

        repeat(n-1) {
            val temp = two
            two += one
            one = temp
        }

        return two
    }
}

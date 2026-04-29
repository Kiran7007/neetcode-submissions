class Solution {
    fun isHappy(n: Int): Boolean {
        var slow = n
        var fast = sumOfSquares(n)

        while(slow != fast) {
            fast = sumOfSquares(sumOfSquares(fast))
            slow = sumOfSquares(slow)
        }

        return fast == 1
    }

    private fun sumOfSquares(n: Int): Int {
        var output = 0
        var num = n
        while(num > 0) {
            val digit = num % 10
            output += digit * digit
            num = num / 10
        }
        return output
    }
}

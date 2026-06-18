class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val n = digits.lastIndex
        for(i in n downTo 0) {
            if(digits[i] < 9) {
                digits[i]++
                return digits
            }
            digits[i] = 0
        }

        return intArrayOf(1) + digits
    }
}

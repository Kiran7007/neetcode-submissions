class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.reduce { a, b -> a xor b}
    }
}

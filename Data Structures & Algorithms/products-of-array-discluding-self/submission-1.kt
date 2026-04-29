class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) { 1 }

        var prefix = 1

        for((i, n) in nums.withIndex()) {
            res[i] = prefix
            prefix *= n
        } 

        var postfix = 1

        for(i in nums.size-1 downTo 0) {
            res[i] *= postfix
            postfix *= nums[i]
        }

        return res
    }
}

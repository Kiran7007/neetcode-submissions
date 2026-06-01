class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size)

        var prefix = 1

        for(i in nums.indices) {
            res[i] = prefix
            prefix *= nums[i]
        }

        var postFix = 1

        for(i in nums.size - 1 downTo 0) {
            res[i] *= postFix
            postFix *= nums[i]
        }

        return res
    }
}

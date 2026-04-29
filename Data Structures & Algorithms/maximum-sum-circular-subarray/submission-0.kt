class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var globMax = nums[0]
        var globMin = nums[0]
        var currMin = 0
        var currMax = 0
        var total = 0

        for(num in nums) {
            currMax = maxOf(currMax + num, num)
            currMin = minOf(currMin + num, num)
            total += num
            globMax = maxOf(globMax, currMax)
            globMin = minOf(globMin, currMin)
        }

        return if(globMax > 0) maxOf(globMax, total - globMin) else globMax
    }
}

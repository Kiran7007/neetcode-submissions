class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }

        for(i in nums.lastIndex downTo 0) {
            for(j in i+1 until nums.size) {
                if(nums[i] < nums[j])
                    dp[i] = max(dp[i], 1 +  dp[j])
            }
        }

        return dp.max()
    }
}

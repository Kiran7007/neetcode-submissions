class Solution {
    fun jump(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1000 }
        dp[nums.lastIndex] = 0

        for(i in nums.lastIndex-1 downTo 0) {
            val end = minOf(nums.size , i+nums[i] + 1)
            for(j in i+1 until end) {
                dp[i] = minOf(dp[i], 1 + dp[j])
            }
        }
        return dp[0]
    }
}

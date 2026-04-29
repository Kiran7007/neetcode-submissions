class Solution {
    fun maxSubArray(nums: IntArray): Int {
       var maxSum = nums[0]
       var currSum = 0

       for(n in nums) {
            if(currSum < 0) currSum = 0
            currSum += n
            maxSum = maxOf(maxSum, currSum)
       } 
       return maxSum
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int windowSum = 0;

        for(int n: nums) {
            if(windowSum < 0) windowSum = 0;
            windowSum += n;
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}

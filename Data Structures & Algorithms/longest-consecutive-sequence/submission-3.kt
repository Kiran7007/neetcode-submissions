class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        var max = 0
        for(n in nums) {
            var longest = 1
            while(numSet.contains(n-longest)) {
                longest++
            }
            max = max(max, longest)
        }

        return max
    }
}

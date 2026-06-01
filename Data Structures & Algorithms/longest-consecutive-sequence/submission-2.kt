class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        var max = 0
        for(n in nums) {
            var longest = 1
            var num = n
            while(numSet.contains(num-1)) {
                longest++
                num--
            }
            max = max(max, longest)
        }

        return max
    }
}

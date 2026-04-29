class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numset = nums.toSet()

        var longest = 0
        for(n in nums) {
            if((n - 1) !in numset) {
                var length = 1
                while((n + length) in numset) {
                    length++
                }
                longest = max(longest, length)
            }
        }

        return longest
    }
}

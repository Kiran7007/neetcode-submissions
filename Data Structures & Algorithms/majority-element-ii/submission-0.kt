class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        nums.sort()
        val maxCount = nums.size / 3
        val res = mutableListOf<Int>()
        var i = 0
        while(i < nums.size) {
            var j = i + 1
            while(j < nums.size && nums[i] == nums[j]) {
                j++
            }

            if(j - i > nums.size/3) {
                res.add(nums[i])
            }
            i = j
        }
        return res.toList()
    }
}

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()

        for(i in nums.indices) {
            if (i > 0 && nums[i] == nums[i-1]) continue

            var j = i + 1
            var k = nums.lastIndex

            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]

                when {
                    sum < 0 -> j++
                    sum > 0 -> k--
                    else -> {
                        res.add(listOf(nums[i], nums[j], nums[k]))
                        j++
                        while(j < k && nums[j] == nums[j-1]) j++
                    }
                }
            }
        }

        return res
    }
}

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()

        for((i, n) in nums.withIndex()) {
            if(i > 0 && nums[i-1] == n) continue

            var l = i + 1
            var r = nums.lastIndex

            while(l < r) {
                val sum = n + nums[l] + nums[r]

                when {
                    sum < 0 -> l++
                    sum > 0 -> r--
                    else -> {
                        res.add(listOf(n, nums[l], nums[r]))
                        l++
                        while(l < r && nums[l] == nums[l-1]) l++
                    }
                }
            }
        }
        return res
    }
}

class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>(listOf())
        nums.sort()
        var idx = 0
        var prevIdx = 0

        for (i in nums.indices) {
            idx = if(i > 0 && nums[i] == nums[i - 1]) prevIdx else 0

            prevIdx = res.size

            for (j in idx until prevIdx) {
                val temp = ArrayList(res[j])
                temp.add(nums[i])
                res.add(temp)
            }
        }

        return res
    }
}

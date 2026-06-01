class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for((i, n) in nums.withIndex()) {
            val diff = target - n

            if(map.contains(diff)) return intArrayOf(map[diff]!!, i)

            map[n] = i
        }

        return intArrayOf()
    }
}

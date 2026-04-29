class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for((i, n) in nums.withIndex()) {
            val res = target -  n
            if(map.contains(res)) {
                return intArrayOf(map[res]!!, i)
            }

            map[n] = i
        }
        return intArrayOf()
    }
}

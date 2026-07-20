class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {

        fun dfs(i : Int, total: Int): Int {
            if(i == nums.size) {
                return if (total == target) 1 else 0
            }

            return dfs(i+1, total + nums[i]) + dfs(i+1, total - nums[i])
        }

        return dfs(0, 0)
    }
}

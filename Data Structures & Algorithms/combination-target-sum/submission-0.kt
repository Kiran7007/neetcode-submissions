class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        nums.sort()

        fun dfs(i: Int, curr: MutableList<Int>, total: Int) {
            if (total == target) {
                res.add(ArrayList(curr))
                return
            }

            for(j in i until nums.size) {
                if(total +  nums[j] > target) return

                curr.add(nums[j])
                dfs(j, curr, total + nums[j])
                curr.removeLast()
            }
        }

        dfs(0, mutableListOf(), 0)

        return res
    }
}

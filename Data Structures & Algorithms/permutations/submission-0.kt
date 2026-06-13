class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun dfs(curr: IntArray, idx: Int) {
            if (idx == curr.size) {
                res.add(curr.toList())
                return
            }

            for(i in idx until curr.size) {
                curr.swap(idx, i)
                dfs(curr, idx + 1)
                curr.swap(idx, i)
            }
        }

        dfs(nums, 0)

        return res
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        candidates.sort()

        fun dfs(i : Int, curr: MutableList<Int>, total: Int) {
            if(total == target) {
                res.add(ArrayList(curr))
                return
            }

            for(j in i until candidates.size) {
                if(j > i && candidates[j] == candidates[j-1]) continue

                if(total + candidates[j] > target) return

                curr.add(candidates[j])
                dfs(j+1, curr, total+candidates[j])
                curr.removeLast()
            }
        }

        dfs(0, mutableListOf(), 0)
        return res
    }
}

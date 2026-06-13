class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>(listOf())

        for(num in nums) {
            val size = res.size

            repeat(size) { i ->
                val subset = res[i].toMutableList()
                subset.add(num) 
                res.add(subset)
            }
        }

        return res
    }
}

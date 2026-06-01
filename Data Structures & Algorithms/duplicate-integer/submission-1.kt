class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val visited = HashSet<Int>()

        for(n in nums) {
            if(!visited.add(n)) return true
        }
        return false
    }
}

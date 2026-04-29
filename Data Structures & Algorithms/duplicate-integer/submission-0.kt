class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        for(n in nums) {
            if(!set.add(n)) return true
        }
        return false
    }
}

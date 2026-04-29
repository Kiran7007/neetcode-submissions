class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val set = HashSet<Int>()

        for(n in nums) {
            if(n in set) {
                return n
            }
            set.add(n)
        }

        return 0
    }
}

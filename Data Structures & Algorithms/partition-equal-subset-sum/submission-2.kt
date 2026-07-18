class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum  = nums.sum()
        if(sum % 2 != 0) return false
        
        val target = sum/2
        var dp = hashSetOf(0)

        for((i, n) in nums.withIndex()) {
            val newDp = HashSet<Int>()

            for(t in dp) {
                if(t + n == target) return true
                newDp.add(t + n)
                newDp.add(t)
            }
            dp = newDp
        }

        return if(target in dp) true else false
    }
}

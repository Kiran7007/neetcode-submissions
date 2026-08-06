class Solution {
    fun jump(nums: IntArray): Int {
        var l = 0
        var r = 0
        var res = 0

        while(r < nums.size - 1) {
            var maxJump = 0

            for(i in l .. r) {
                maxJump = max(maxJump, i + nums[i])
            }

            l = r + 1
            r = maxJump
            res++
        }

        return res
    }
}

class Solution {
    fun majorityElement(nums: IntArray): Int {
        var res = 0
        var count = 0

        for(n in nums) {
            if (count == 0) {
                res = n
            }

            count += if(res == n) +1 else -1
        }

        return res
    }
}

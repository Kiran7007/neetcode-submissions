class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        val n = nums.size
        var num1 = -1
        var num2 = -1
        var cnt1 = 0
        var cnt2 = 0

        for (num in nums) {
            when {
                num == num1 -> cnt1++
                num == num2 -> cnt2++
                cnt1 == 0 -> { cnt1 = 1; num1 = num }
                cnt2 == 0 -> { cnt2 = 1; num2 = num }
                else -> { cnt1--; cnt2-- }
            }
        }

        cnt1 = 0
        cnt2 = 0
        for (num in nums) {
            if (num == num1) cnt1++
            else if (num == num2) cnt2++
        }

        val res = mutableListOf<Int>()
        if (cnt1 > n / 3) res.add(num1)
        if (cnt2 > n / 3) res.add(num2)

        return res
    }
}
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var res = 0
        var prefixSum = hashMapOf<Int, Int>(0 to 1)
        var currSum = 0

        for(n in nums) {
            currSum += n
            val diff = currSum - k
            res += prefixSum.getOrDefault(diff, 0)
            prefixSum[currSum] = prefixSum.getOrDefault(currSum, 0) + 1
        }

        return res
    }
}

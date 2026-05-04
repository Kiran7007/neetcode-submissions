class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size

        while(l < r) {
            val mid = l + (r-l) / 2
            when {
                nums[mid] < target -> l = mid+1
                nums[mid] > target -> r = mid
                nums[mid] == target -> return mid
                else -> return -1
            }
        }

        return -1
    }
}

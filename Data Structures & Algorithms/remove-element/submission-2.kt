class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        var n = nums.size

        while(i < n) {
            if(nums[i] == `val`) {
                n--
                nums[i] = nums[n]
            } else {
                i++
            }
        }

        return n
    }
}

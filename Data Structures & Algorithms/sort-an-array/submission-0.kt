class Solution {
    fun sortArray(nums: IntArray): IntArray {
        val size = nums.size
        if(size == 1) return nums

        fun shellSort(n: Int) {
            var gap = n/2

            while(gap >= 1) {
                for(i in gap until n) {
                    val tmp = nums[i]
                    var j = i - gap

                    while(j >= 0 && nums[j] > tmp) {
                        nums[j+gap] = nums[j]
                        j -= gap
                    }
                    nums[j+gap] = tmp 
                }
                gap /= 2
            }
        }
        shellSort(size)
        return nums
    }
}

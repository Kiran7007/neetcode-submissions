class Solution {
    fun maxArea(heights: IntArray): Int {
        var l = 0 
        var r = heights.lastIndex
        var maxWater = 0

        while (l < r) {
            val minHeight = min(heights[l], heights[r])
            maxWater = max(maxWater, minHeight * (r - l))

            while(l < r && heights[l] <= minHeight) l++
            while(l < r && heights[r] <= minHeight) r--
        }

        return maxWater
    }
}

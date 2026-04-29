class Solution {
    fun maxArea(heights: IntArray): Int {
        var maxWater = 0
        var left = 0
        var right = heights.lastIndex

        while(left < right) {
            val minHeight = minOf(heights[left], heights[right])
            maxWater = maxOf(maxWater, minHeight * (right - left))

            while(left < right && heights[left] <= minHeight) left++
            while(left < right && heights[right] <= minHeight) right--
        }
        return maxWater
    }
}

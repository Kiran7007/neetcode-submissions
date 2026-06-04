class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val n = heights.size
        val stack = Stack<Int>()
        var maxArea = 0

        for(i in 0..n) {
            while (stack.isNotEmpty() && (i==n || heights[stack.peek()] >= heights[i])) {
                val height = heights[stack.pop()]
                val width = if(stack.isEmpty()) i else i-stack.peek() - 1
                maxArea = max(maxArea, height * width)
            }
            if(i < n) stack.push(i)
        }

        return maxArea
    }
}

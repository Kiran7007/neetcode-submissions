class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = position.zip(speed).sortedByDescending { it.first}

        val stack = Stack<Double>()
        for((p, s) in cars) {
            stack.push((target - p)*1.0 / s)
            if(stack.size >= 2 && stack[stack.lastIndex] <= stack[stack.lastIndex-1]) {
                stack.pop()
            }
        }

        return stack.size
    }
}

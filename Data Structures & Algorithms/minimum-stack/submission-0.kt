class MinStack() {
    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        val min = if(minStack.isEmpty()) `val` else min(`val`, minStack.last())
        minStack.addLast(min)
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        if(stack.isEmpty()) return -1
        return stack.last()
    }

    fun getMin(): Int {
        if(minStack.isEmpty()) return -1
        return minStack.last()
    }
}

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for(c in tokens) {
            if(c !in listOf("+", "-", "*", "/")) {
                stack.addLast(c.toInt())
            } else {
                val a = stack.removeLast().toInt()
                val b = stack.removeLast().toInt()

                when(c) {
                    "+" -> stack.addLast(a + b)
                    "-" -> stack.addLast(b - a)
                    "*" -> stack.addLast(a * b)
                    "/" -> stack.addLast(b / a)
                }
            }
        }

        return stack.peek()
    }
}

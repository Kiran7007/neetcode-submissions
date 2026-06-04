class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()

        for(c in tokens) {
            if(c !in listOf("+", "-", "*", "/")) {
                stack.push(c.toInt())
            } else {
                val a = stack.pop()
                val b = stack.pop()

                when(c) {
                    "+" -> stack.push(a + b)
                    "-" -> stack.push(b - a)
                    "*" -> stack.push(a * b)
                    "/" -> stack.push(b / a)
                }
            }
        }

        return stack.peek()
    }
}

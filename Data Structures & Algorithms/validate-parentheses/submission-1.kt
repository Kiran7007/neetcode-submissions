class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for(c in s) {
            when(c) {
                '(' -> stack.push(')')
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                else -> {
                    if(stack.isEmpty()) return false
                    if(stack.peek() != c) return false
                    stack.pop()
                }
            }
        }

        return stack.isEmpty()
    }
}

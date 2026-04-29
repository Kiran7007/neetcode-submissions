/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    private val map = HashMap<Node, Node>()

    fun copyRandomList(head: Node?): Node? {
        if (head == null) {
            return null
        }
        if (map.containsKey(head)) {
            return map[head]
        }

        val copy = Node(head.`val`)
        map[head] = copy
        copy.next = copyRandomList(head.next)
        copy.random = map[head.random]
        return copy
    }
}

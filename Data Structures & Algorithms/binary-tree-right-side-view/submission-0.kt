/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val res = mutableListOf<Int>()
        val q = ArrayDeque(listOf(root))

        while (q.isNotEmpty()) {
            var rightSide: TreeNode? = null

            repeat(q.size) {
                val node = q.poll()
                if (node != null) {
                    rightSide = node
                    node.left?.let { q.add(it) }
                    node.right?.let { q.add(it) }
                }
            }
            rightSide?.let { res.add(it.`val`) }
        }

        return res
    }
}

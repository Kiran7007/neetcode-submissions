/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        if(root == null) return res

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while(queue.isNotEmpty()) {
            val size = queue.size

            val list = mutableListOf<Int>()
            repeat(size) {
                val node = queue.poll()

                node?.let { list.add(it.`val`) }
                node?.left?.let { queue.add(it) }
                node?.right?.let { queue.add(it) }
            }
            res.add(list)
        }
        return res
    }
}

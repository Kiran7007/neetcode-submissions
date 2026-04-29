/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var result = 0

        while(queue.isNotEmpty()) {
            val size = queue.size
            
            repeat(size) {
                val node = queue.poll()
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            } 
            result++
        }
        return result
    }
}

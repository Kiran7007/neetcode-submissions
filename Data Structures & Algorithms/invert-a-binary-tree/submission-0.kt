/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null) return null

        val isBFS = true
        if(isBFS) {
            val queue = ArrayDeque<TreeNode>()
            queue.add(root)

            while(queue.isNotEmpty()) {
                val node = queue.poll()
            
                node?.let {
                    val temp = node.left
                    node.left = node.right
                    node.right = temp
                    node.left?.let { queue.add(it) }
                    node.right?.let { queue.add(it) }
                }
            }
        } else {
            val temp = root.left
            root.left = root.right
            root.right = temp

            invertTree(root.left)
            invertTree(root.right)
        }

        return root
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var res = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return res
    }

    private fun dfs(node: TreeNode?): Int {
        if(node == null) return 0

        val left = dfs(node?.left)
        val right = dfs(node?.right)
        res = max(res, left + right)

        return 1 + max(dfs(node?.left), dfs(node?.right))
    }
}

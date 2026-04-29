/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(subRoot == null) return true
        if(root == null) return false

        fun isSame(root: TreeNode?, target: TreeNode?): Boolean {
            if(root == target) return true
            if(root?.`val` != target?.`val`) return false

            return isSame(root?.left, target?.left) && isSame(root?.right, target?.right)
        }

        return isSame(root, subRoot) ||
        isSubtree(root?.left, subRoot) ||
        isSubtree(root?.right, subRoot)
    }
}

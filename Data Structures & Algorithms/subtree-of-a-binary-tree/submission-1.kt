/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(root == null)  return false
        if(subRoot == null)  return true

        fun isSame(root: TreeNode?, subTree: TreeNode?): Boolean {
            if(root == null && subTree == null) return root == subTree 
            if(root?.`val` != subTree?.`val`) return false

            return isSame(root?.left, subTree?.left) && isSame(root?.right, subTree?.right)
        }

        return isSame(root, subRoot)
        || isSubtree(root?.left, subRoot) 
        || isSubtree(root?.right, subRoot)
    }
}

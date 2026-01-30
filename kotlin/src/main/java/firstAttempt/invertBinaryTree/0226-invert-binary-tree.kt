package firstAttempt.invertBinaryTree

import common.TreeNode

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
// https://leetcode.com/problems/invert-binary-tree/description/
class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        fun dfs(node: TreeNode): TreeNode {
            val newLeft = node.right
            val newRight = node.left

            node.left = newLeft?.let {
                dfs(newLeft)
            }

            node.right = newRight?.let {
                dfs(newRight)
            }

            return node
        }

        return root?.let { dfs(it) }
    }
}
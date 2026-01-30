package firstAttempt.validateBinarySearchTree

import common.TreeNode

// https://leetcode.com/problems/validate-binary-search-tree/description/
class Solution {

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true

        fun dfs(node: TreeNode, min: Long, max: Long): Boolean {
            if (node.value !in min..max) return false

            //     5
            //   2   8
            //  1

            val isLeftValid = node.left?.let {
                dfs(it, min, node.value - 1L)
            } ?: true

            val isRightValid = node.right?.let {
                dfs(it, node.value + 1L, max)
            } ?: true

            return isLeftValid && isRightValid
        }

        return dfs(root, Int.MIN_VALUE.toLong(), Int.MAX_VALUE.toLong())
    }

    val TreeNode.value
        get() = this.`val`
}
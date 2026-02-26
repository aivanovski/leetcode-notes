package secondAttempt.diameterofBinaryTree

import common.TreeNode

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0

        var maxDiameter = 0

        fun dfs(node: TreeNode): Int {
            val leftHeight = node.left?.let { dfs(it) } ?: 0
            val rightHeight = node.right?.let { dfs(it) } ?: 0

            maxDiameter = maxOf(maxDiameter, leftHeight + rightHeight)

            return maxOf(leftHeight, rightHeight) + 1
        }

        dfs(root)

        return maxDiameter
    }
}
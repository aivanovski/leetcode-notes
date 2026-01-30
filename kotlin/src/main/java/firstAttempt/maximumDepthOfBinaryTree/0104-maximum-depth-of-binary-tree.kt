package firstAttempt.maximumDepthOfBinaryTree

import common.TreeNode
import kotlin.math.max

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        fun dfs(node: TreeNode, depth: Int): Int {

            val leftDepth = if (node.left != null) {
                dfs(node.left!!, depth + 1)
            } else {
                depth
            }

            val rightDepth = if (node.right != null) {
                dfs(node.right!!, depth + 1)
            } else {
                depth
            }

            return max(leftDepth, rightDepth)
        }

        return dfs(root, 1)
    }
}
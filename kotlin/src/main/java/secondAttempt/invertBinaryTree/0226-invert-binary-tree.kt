package secondAttempt.invertBinaryTree

import common.TreeNode

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        val left = root?.left
        val right = root?.right

        if (left != null) {
            invertTree(left)
        }

        if (right != null) {
            invertTree(right)
        }

        root?.left = right
        root?.right = left


        return root
    }
}
package secondAttempt.validateBinarySearchTree

import common.TreeNode

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return if (root != null) {
            isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)
        } else {
            false
        }
    }

    private fun isValid(node: TreeNode, min: Long, max: Long): Boolean {
        if (node.value !in min..max) return false

        // max = node.value - 1
        val isLeftValid = node.left?.let { isValid(it, min, node.value - 1L) } ?: true

        // min = node.value + 1
        val isRightValid = node.right?.let { isValid(it, node.value + 1L, max) } ?: true

        return isLeftValid && isRightValid
    }

    private val TreeNode.value: Int
        get() = this.`val`
}
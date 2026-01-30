package firstAttempt.subtreeOfAnotherTree

import common.TreeNode

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true
        if (root == null) return false

        if (root.value == subRoot.value && isSameTree(root, subRoot)) {
            return true
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun isSameTree(lhs: TreeNode?, rhs: TreeNode?): Boolean {
        return if (lhs == null && rhs == null) {
            true
        } else if (lhs?.value != rhs?.value) {
            false
        } else {
            isSameTree(lhs?.left, rhs?.left) && isSameTree(lhs?.right, rhs?.right)
        }
    }

    private val TreeNode.value: Int
        get() = this.`val`
}

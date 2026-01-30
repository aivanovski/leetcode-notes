package secondAttempt.subtreeofAnotherTree

import common.TreeNode

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false

        if (root.value == subRoot?.value && isSameTree(root, subRoot)) {
            return true
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
        }
    }

    private fun isSameTree(lhs: TreeNode?, rhs: TreeNode?): Boolean {
        if (lhs == null && rhs == null) return true
//        if (lhs?.value != rhs?.value) return false

        val isLeftSame = isSameTree(lhs?.left, rhs?.left)
        val isRightSame = isSameTree(lhs?.right, rhs?.right)

        return isLeftSame && isRightSame && lhs?.value == rhs?.value
    }

    private val TreeNode.value: Int
        get() = this.`val`
}
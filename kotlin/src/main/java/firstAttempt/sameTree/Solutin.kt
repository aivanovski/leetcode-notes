package firstAttempt.sameTree

import common.TreeNode

class Solution {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

        fun dfs(lhs: TreeNode?, rhs: TreeNode?): Boolean {
            if (lhs == null && rhs == null) return true

            return if (lhs?.value != rhs?.value) {
                false
            } else {
                dfs(lhs?.left, rhs?.left) && dfs(lhs?.right, rhs?.right)
            }
        }

        return dfs(p, q)
    }

    val TreeNode.value
        get() = this.`val`
}
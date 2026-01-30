package secondAttempt.sameTree

import common.TreeNode

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p?.value != q?.value) return false

        val isLeftSame = isSameTree(p?.left, q?.left)
        val isRightSame = isSameTree(p?.right, q?.right)

        return isLeftSame && isRightSame
    }

    private val TreeNode.value: Int get() = this.`val`
}
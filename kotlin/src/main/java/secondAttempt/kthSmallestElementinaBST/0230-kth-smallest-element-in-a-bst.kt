package secondAttempt.kthSmallestElementinaBST

import common.TreeNode

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) return -1

        val values = mutableListOf<Int>()

        fun dfs(node: TreeNode) {
            node.left?.let { dfs(it) }
            values.add(node.value)
            node.right?.let { dfs(it) }
        }

        dfs(root)

        return values[k - 1]
    }

    private val TreeNode.value: Int get() = this.`val`
}
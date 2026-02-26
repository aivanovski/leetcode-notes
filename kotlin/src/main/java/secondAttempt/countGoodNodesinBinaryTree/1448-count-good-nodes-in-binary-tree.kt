package secondAttempt.countGoodNodesinBinaryTree

import common.TreeNode

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0

        var count = 0

        fun dfs(node: TreeNode, maxValue: Int) {
            if (node.value >= maxValue) {
                count++
            }

            val m = maxOf(maxValue, node.value)
            node.left?.let { dfs(it, m) }
            node.right?.let { dfs(it, m) }
        }

        dfs(root, root.value)

        return count
    }

    private val TreeNode.value: Int
        get() = this.`val`
}
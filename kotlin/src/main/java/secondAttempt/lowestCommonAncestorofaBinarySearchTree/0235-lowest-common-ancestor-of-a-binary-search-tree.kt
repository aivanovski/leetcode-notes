package secondAttempt.lowestCommonAncestorofaBinarySearchTree

import common.TreeNode

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null

        fun dfs(node: TreeNode?): TreeNode? {
            if (node == null) return null

            return when {
                maxOf(p.value, q.value) < node.value -> dfs(node.left)
                minOf(p.value, q.value) > node.value -> dfs(node.right)
                else -> node
            }
        }

        return dfs(root)
    }

    private val TreeNode.value: Int
        get() = this.`val`
}
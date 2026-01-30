package firstAttempt.lowestCommonAncestorOfABinarySearchTree

import common.TreeNode
import kotlin.math.max
import kotlin.math.min

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null

        //     6
        //   2   7
        //  1 4 * 8
        // 0

        // p = 1
        // q = 4

        val targetMin = min(p?.value ?: 0, q?.value ?: 0)
        val targetMax = max(p?.value ?: 0, q?.value ?: 0)

        val lowest = mutableListOf(root)

        fun dfs(node: TreeNode, parentRange: IntRange) {
            val isInLeftSubTree = (targetMin <= node.value && targetMin in parentRange)
            val isInRightSubTree = (targetMax >= node.value && targetMax in parentRange)

            if (isInLeftSubTree
                && isInRightSubTree
            ) {
                if (node.value < lowest[0].value || node.value > lowest[0].value) {
                    lowest[0] = node
                }
            }

            node.left?.let { dfs(it, parentRange.start..node.value - 1) }
            node.right?.let { dfs(it, node.value + 1..parentRange.endInclusive) }
        }

        dfs(root, Int.MIN_VALUE..Int.MAX_VALUE)

        return lowest[0]
    }

    val TreeNode.value: Int
        get() = this.`val`
}
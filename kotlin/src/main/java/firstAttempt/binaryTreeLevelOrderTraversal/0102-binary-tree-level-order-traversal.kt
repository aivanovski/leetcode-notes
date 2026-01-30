package firstAttempt.binaryTreeLevelOrderTraversal

import common.TreeNode
import java.util.LinkedList

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val nextNodes = LinkedList<TreeNode>()
            .apply {
                add(root)
            }

        val result = mutableListOf<List<Int>>()

        while (nextNodes.isNotEmpty()) {
            val layer = mutableListOf<Int>()

            repeat(nextNodes.size) {
                val node = nextNodes.removeFirst()

                layer.add(node.value)

                node.left?.let { nextNodes.add(it) }
                node.right?.let { nextNodes.add(it) }
            }

            result.add(layer)
        }

        return result
    }

    val TreeNode.value: Int
        get() = this.`val`
}

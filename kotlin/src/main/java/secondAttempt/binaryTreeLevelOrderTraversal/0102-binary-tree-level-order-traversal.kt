package secondAttempt.binaryTreeLevelOrderTraversal

import common.TreeNode
import java.util.LinkedList

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val queue = LinkedList<TreeNode>()
            .apply {
                add(root)
            }

        val levels = mutableListOf<List<Int>>()
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()

            repeat(queue.size) {
                val node = queue.removeFirst()

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }

                level.add(node.value)
            }

            levels.add(level)
        }

        return levels
    }

    private val TreeNode.value: Int
        get() = this.`val`
}
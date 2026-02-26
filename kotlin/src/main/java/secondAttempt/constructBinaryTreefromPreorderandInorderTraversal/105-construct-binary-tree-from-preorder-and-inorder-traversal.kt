package secondAttempt.constructBinaryTreefromPreorderandInorderTraversal

import com.sun.source.tree.Tree
import common.TreeNode

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // 3,9,20,15,7   pre
        // 9,3,15,20,7   in

        val nodeToIndexMap = inorder.withIndex()
            .associate { (index, value) -> value to index }

        var preorderIndex = 0

        fun dfs(left: Int, right: Int): TreeNode? {
            if (left > right) return null

            val nodeValue = preorder[preorderIndex++]
            val node = TreeNode(nodeValue)
            if (left == right) {
                return node
            }

            val inorderIndex = nodeToIndexMap[nodeValue] ?: 0

            node.left = dfs(left, inorderIndex - 1)
            node.right = dfs(inorderIndex + 1, right)

            return node
        }

        return dfs(0, preorder.lastIndex)
    }
}
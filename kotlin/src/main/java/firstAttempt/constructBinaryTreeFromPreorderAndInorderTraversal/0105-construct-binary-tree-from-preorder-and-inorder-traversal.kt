package firstAttempt.constructBinaryTreeFromPreorderAndInorderTraversal

import common.TreeNode
import kotlin.math.max

class Solution {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val result = buildTree(preorder.toList(), inorder.toList())
        return result
    }

    private fun buildTree(
        preorder: List<Int>,
        inorder: List<Int>
    ): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) return null

        val rootValue = preorder.first()
        val root = TreeNode(preorder.first())

        val inOrderIndex = inorder.indexOfFirst { value -> value == rootValue }

        val leftNodeCount = inOrderIndex
        val rightNodeCount = max(0, inorder.size - (inOrderIndex + 1))

        root.left = when {
            leftNodeCount > 1 -> buildTree(
                preorder = preorder.subList(1, preorder.size),
                inorder = inorder.subList(0, inOrderIndex)
            )

            leftNodeCount == 1 -> TreeNode(inorder.first())
            else -> null
        }

        root.right = when {
            rightNodeCount > 1 -> buildTree(
                preorder = preorder.subList(leftNodeCount + 1, preorder.size),
                inorder = inorder.subList(inOrderIndex + 1, inorder.size)
            )

            rightNodeCount == 1 -> TreeNode(inorder[inOrderIndex + 1])
            else -> null
        }

        return root
    }
}
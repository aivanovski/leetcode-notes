package secondAttempt.maximumDepthOfBinaryTree

import common.TreeNode
import kotlin.math.max

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + max(maxDepth(root.left), maxDepth(root.right))
    }
}
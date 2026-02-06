package secondAttempt.lowestCommonAncestorOfABinarySearchTree

import common.findNode
import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import secondAttempt.lowestCommonAncestorofaBinarySearchTree.Solution

class SolutionTest {
    @Test
    fun lowestCommonAncestor() {
        listOf(
            Pair(
                listOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                7 to 9
            ) to 8,
        ).forEach { (input, expected) ->
            val tree = input.first.toTreeNodes()
            val p = tree?.findNode(input.second.first)
            val q = tree?.findNode(input.second.second)
            Solution().lowestCommonAncestor(tree, p, q)?.`val` shouldBe expected
        }
    }
}
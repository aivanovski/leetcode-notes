package firstAttempt.lowestCommonAncestorOfABinarySearchTree

import common.findNode
import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun lowestCommonAncestor() {
        listOf(
            Triple(listOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5), 2, 8) to 6,
            Triple(listOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5), 2, 4) to 2,
            Triple(listOf(6, 2, 7, 1, 4, null, 8), 2, 4) to 2,
            Triple(listOf(6, 2, 7, 1, 4, null, 8), 1, 4) to 2,
        ).forEach { (input, expected) ->
            val tree = input.first.toTreeNodes()

            val result = Solution().lowestCommonAncestor(
                tree,
                tree?.findNode(input.second),
                tree?.findNode(input.third)
            )

            result?.`val` shouldBe expected
        }
    }
}
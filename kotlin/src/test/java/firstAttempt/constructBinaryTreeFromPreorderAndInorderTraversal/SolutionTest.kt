package firstAttempt.constructBinaryTreeFromPreorderAndInorderTraversal

import common.collectTreeStructure
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun buildTree() {
        listOf(
            Pair(
                listOf(3, 9, 20, 15, 7),
                listOf(9, 3, 15, 20, 7)
            ) to listOf(3, 9, 20, null, null, 15, 7),
            Pair(
                listOf(1, 2, 4, 5, 7, 8, 3, 6),
                listOf(4, 2, 7, 5, 8, 1, 3, 6)
            ) to listOf(1, 2, 3, 4, 5, null, 6, null, null, 7, 8),
        ).forEach { (input, expected) ->
            Solution().buildTree(
                input.first.toIntArray(),
                input.second.toIntArray()
            )?.collectTreeStructure() shouldBe expected
        }
    }
}
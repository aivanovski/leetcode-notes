package secondAttempt.constructBinaryTreefromPreorderandInorderTraversal

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
        ).forEach { (input, expected) ->
            val result = Solution().buildTree(
                input.first.toIntArray(),
                input.second.toIntArray()
            )?.collectTreeStructure()

            result shouldBe expected
        }
    }

}
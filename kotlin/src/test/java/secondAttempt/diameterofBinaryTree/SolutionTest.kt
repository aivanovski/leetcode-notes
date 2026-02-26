package secondAttempt.diameterofBinaryTree

import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun diameterOfBinaryTree() {
        listOf(
            listOf(1, 2, 3, 4, 5) to 3
        ).forEach { (input, expected) ->
            Solution().diameterOfBinaryTree(input.toTreeNodes()) shouldBe expected
        }
    }
}
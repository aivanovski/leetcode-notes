package secondAttempt.maximumDepthOfBinaryTree

import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun maxDepth() {
        listOf(
            listOf(3, 9, 20, null, null, 15, 7) to 3,
        ).forEach { (input, expected) ->
            Solution().maxDepth(input.toTreeNodes()) shouldBe expected
        }
    }
}
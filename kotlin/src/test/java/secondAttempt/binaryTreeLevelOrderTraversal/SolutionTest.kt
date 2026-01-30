package secondAttempt.binaryTreeLevelOrderTraversal

import common.toTreeNodes
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun levelOrder() {
        listOf(
            listOf(3, 9, 20, null, null, 15, 7) to "[[3],[9,20],[15,7]]",
        ).forEach { (input, expected) ->
            Solution().levelOrder(
                input.toTreeNodes()
            ) shouldBe expected.toTwoDimensionalList()
        }
    }

}
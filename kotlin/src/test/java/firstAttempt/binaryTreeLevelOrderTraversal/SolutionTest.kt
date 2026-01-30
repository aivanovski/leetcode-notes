package firstAttempt.binaryTreeLevelOrderTraversal

import common.filterNumbers
import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun levelOrder() {
        listOf(
            listOf(3, 9, 20, null, null, 15, 7) to "[[3],[9,20],[15,7]]",
            listOf<Int?>() to "",
        ).forEach { (input, expected) ->
            Solution().levelOrder(input.toTreeNodes()).flatten() shouldBe expected.filterNumbers()
        }
    }
}
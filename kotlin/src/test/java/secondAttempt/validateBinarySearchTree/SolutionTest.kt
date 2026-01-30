package secondAttempt.validateBinarySearchTree

import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isValidBST() {
        listOf(
            listOf(2, 1, 3) to true,
            listOf(5, 1, 4, null, null, 3, 6) to false,
            listOf(1,null, 1) to false,
        ).forEach { (input, expected) ->
            Solution().isValidBST(input.toTreeNodes()) shouldBe expected
        }
    }
}
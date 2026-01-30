package firstAttempt.validateBinarySearchTree

import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isValidBST() {
        listOf(
//            listOf(5, 1, 4, null, null, 3, 6) to false,
            listOf(-2147483648,-2147483648) to false
        ).forEach { (input, expected) ->
            Solution().isValidBST(input.toTreeNodes()) shouldBe expected
        }
    }

}
package secondAttempt.spiralMatrix

import common.toArrays
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun spiralOrder() {
        listOf(
            "[[1,2,3],[4,5,6],[7,8,9]]" to listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),
            "[[3],[2]]" to listOf(3, 2),
            "[[1,2],[3,4]]" to listOf(1, 2, 4, 3),
        ).forEach { (input, expected) ->
            val matrix = input.toTwoDimensionalList().toArrays()
            Solution().spiralOrder(matrix) shouldBe expected
        }
    }
}
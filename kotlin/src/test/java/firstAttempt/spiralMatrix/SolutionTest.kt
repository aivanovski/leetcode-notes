package firstAttempt.spiralMatrix

import common.toGrid
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun spiralOrder() {
        listOf(
            listOf(
                listOf(1, 2, 3),
                listOf(4, 5, 6),
                listOf(7, 8, 9),
            ) to listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),

            //[1,2,3,4],[5,6,7,8],[9,10,11,12]
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 10, 11, 12),
            ) to listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),

            listOf(
                listOf(1, 2),
                listOf(3, 4),
            ) to listOf(1, 2, 4, 3),
        ).forEach { (input, expected) ->
            Solution().spiralOrder(
                matrix = input.map { it.toIntArray() }.toTypedArray()
            ) shouldBe expected
        }
    }
}
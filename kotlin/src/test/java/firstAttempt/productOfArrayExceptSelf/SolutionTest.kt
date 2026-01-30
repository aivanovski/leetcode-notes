package firstAttempt.productOfArrayExceptSelf

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun productExceptSelf() {
        listOf(
            listOf(1, 2, 3, 4) to listOf(24, 12, 8, 6),
            listOf(-1, 1, 0, -3, 3) to listOf(0, 0, 9, 0, 0),
        ).forEach { (input, expected) ->
            Solution().productExceptSelf(input.toIntArray()) shouldBe expected.toIntArray()
        }
    }
}
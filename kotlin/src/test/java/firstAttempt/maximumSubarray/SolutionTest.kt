package firstAttempt.maximumSubarray

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun maxSubArray() {
        listOf(
            listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4) to 6,
            listOf(5, 4, -1, 7, 8) to 23,
            listOf(-1) to -1
        ).forEach { (input, expected) ->
            Solution().maxSubArray(input.toIntArray()) shouldBe expected
        }
    }
}
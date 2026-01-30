package firstAttempt.containerWithMostWater

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun maxArea() {
        listOf(
            listOf(1, 8, 6, 2, 5, 4, 8, 3, 7) to 49,
            listOf(2, 3, 10, 5, 7, 8, 9) to 36,
        ).forEach { (input, expected) ->
            Solution().maxArea(input.toIntArray()) shouldBe expected
        }
    }
}
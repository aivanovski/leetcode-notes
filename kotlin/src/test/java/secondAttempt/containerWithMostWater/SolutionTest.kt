package secondAttempt.containerWithMostWater

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun maxArea() {
        listOf(
            listOf(1, 8, 6, 2, 5, 4, 8, 3, 7) to 49,
        ).forEach { (input, expected) ->
            Solution().maxArea(input.toIntArray()) shouldBe expected
        }
    }
}
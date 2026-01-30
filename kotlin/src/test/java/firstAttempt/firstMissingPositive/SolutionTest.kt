package firstAttempt.firstMissingPositive

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun firstMissingPositive() {
        listOf(
            listOf(1, 2, 0) to 3,
            listOf(3, 4, -1, 1) to 2,
            listOf(7, 8, 9, 11, 12) to 1,
            listOf(1) to 2,
            listOf(1,1) to 2,
        ).forEach { (input, expected) ->
            Solution().firstMissingPositive(input.toIntArray()) shouldBe expected
        }
    }
}
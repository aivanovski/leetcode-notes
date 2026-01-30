package firstAttempt.countingBits

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun countBits() {
        listOf(
            2 to listOf(0, 1, 1),
            5 to listOf(0, 1, 1, 2, 1, 2),
            8 to listOf(0, 1, 1, 2, 1, 2, 2, 3, 1),
        ).forEach { (input, expected) ->
            Solution().countBits(input).toList() shouldBe expected
        }
    }
}
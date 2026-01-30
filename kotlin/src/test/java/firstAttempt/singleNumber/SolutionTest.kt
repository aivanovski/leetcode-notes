package firstAttempt.singleNumber

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun singleNumber() {
        listOf(
            listOf(2, 2, 1) to 1,
            listOf(4, 1, 2, 1, 2) to 4,
        ).forEach { (input, expected) ->
            Solution().singleNumber(input.toIntArray()) shouldBe expected
        }
    }
}
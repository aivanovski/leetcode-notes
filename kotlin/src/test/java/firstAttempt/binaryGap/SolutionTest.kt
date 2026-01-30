package firstAttempt.binaryGap

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun binaryGap() {
        listOf(
            22 to 2,
            8 to 0,
            5 to 2,
            6 to 1,
        ).forEach { (input, expected) ->
            Solution().binaryGap(input) shouldBe expected
        }
    }
}
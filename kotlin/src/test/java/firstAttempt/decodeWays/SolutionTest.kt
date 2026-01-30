package firstAttempt.decodeWays

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun numDecodings() {
        listOf(
            "12" to 2,
            "226" to 3,
            "06" to 0,
            "11106" to 2,
            "10011" to 0,
        ).forEach { (input, expected) ->
            Solution().numDecodings(input) shouldBe expected
        }
    }
}
package firstAttempt.longestRepeatingCharacterReplacement

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun characterReplacement() {
        listOf(
            Pair("ABAB", 2) to 4,
            Pair("AABABBA", 1) to 4,
        ).forEach { (input, expected) ->
            Solution().characterReplacement(input.first, input.second) shouldBe expected
        }
    }
}
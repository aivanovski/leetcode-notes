package secondAttempt.minimumWindowSubstring

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun minWindow() {
        listOf(
            Pair("ADOBECODEBANC", "ABC") to "BANC",
            Pair("cabwefgewcwaefgcf", "cae") to "cwae",
        ).forEach { (input, expected) ->
            Solution().minWindow(input.first, input.second) shouldBe expected
        }
    }
}
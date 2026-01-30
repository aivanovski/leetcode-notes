package secondAttempt.longestSubstringWithoutRepeatingCharacters

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun lengthOfLongestSubstring() {
        listOf(
            "abcabcbb" to 3,
            "tmmzuxt" to 5,
        ).forEach { (input, expected) ->
            Solution().lengthOfLongestSubstring(input) shouldBe expected
        }
    }
}
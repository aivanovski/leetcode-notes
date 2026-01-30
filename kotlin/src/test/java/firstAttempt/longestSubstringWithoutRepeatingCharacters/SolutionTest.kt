package firstAttempt.longestSubstringWithoutRepeatingCharacters

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun lengthOfLongestSubstring() {
        listOf(
            "abcabcbb" to 3,
            "bbbbb" to 1,
            "pwwkew" to 3,
        ).forEach { (input, expected) ->
            Solution().lengthOfLongestSubstring(input) shouldBe expected
        }
    }
}
package firstAttempt.longestPalindromicSubstring

import io.kotest.matchers.collections.shouldBeIn
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun longestPalindrome() {
        listOf(
            "babad" to setOf("bab", "aba"),
            "cbbd" to setOf("bb"),
            "a" to setOf("a"),
            "" to setOf(""),
            "abbcccba" to setOf("bcccb"),
        ).forEach { (input, expected) ->
            Solution().longestPalindrome(input) shouldBeIn expected
        }
    }
}
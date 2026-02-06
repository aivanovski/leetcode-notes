package secondAttempt.longestPalindromicSubstring

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun longestPalindrome() {
        listOf(
            "babad" to "aba",
            "cbbd" to "bb",
        ).forEach { (input, expected) ->
            Solution().longestPalindrome(input) shouldBe expected
        }
    }

}
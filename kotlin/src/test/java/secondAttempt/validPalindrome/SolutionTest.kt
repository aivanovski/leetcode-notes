package secondAttempt.validPalindrome

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isPalindrome() {
        listOf(
            "A man, a plan, a canal: Panama" to true,
            " " to true,
            "0P" to false,
        ).forEach { (input, expected) ->
            Solution().isPalindrome(input) shouldBe expected
        }
    }
}
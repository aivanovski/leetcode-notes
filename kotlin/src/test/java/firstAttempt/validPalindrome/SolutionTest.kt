package firstAttempt.validPalindrome

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isPalindrome() {
        listOf(
            "A man, a plan, a canal: Panama" to true,
            "race a car" to false,
            "" to true,
            "a" to true
        ).forEach { (input, expected) ->
            Solution().isPalindrome(input) shouldBe expected
        }
    }
}
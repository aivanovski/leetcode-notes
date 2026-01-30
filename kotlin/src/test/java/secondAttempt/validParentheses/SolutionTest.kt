package secondAttempt.validParentheses

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isValid() {
        listOf(
            "()[]{}" to true,
            "([)]" to false,
            "([])" to true,
        ).forEach { (input, expected) ->
            Solution().isValid(input) shouldBe expected
        }
    }
}
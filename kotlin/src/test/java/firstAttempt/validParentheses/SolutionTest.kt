package firstAttempt.validParentheses

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isValid() {
        listOf(
//            "()[]{}" to true,
            "([])" to true,
            "([)]" to false,
        ).forEach { (input, expected) ->
            Solution().isValid(input) shouldBe expected
        }

    }
}
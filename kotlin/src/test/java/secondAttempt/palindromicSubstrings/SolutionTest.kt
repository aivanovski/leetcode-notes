package secondAttempt.palindromicSubstrings

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun countSubstrings() {
        listOf(
            "abc" to 3,
            "aaa" to 6,
        ).forEach { (input, expected) ->
            Solution().countSubstrings(input) shouldBe expected
        }
    }
}
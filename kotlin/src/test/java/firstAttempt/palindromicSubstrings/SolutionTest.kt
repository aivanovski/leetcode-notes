package firstAttempt.palindromicSubstrings

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun countSubstrings() {
        listOf(
            "aaa" to 6,
            "abc" to 3,
        ).forEach { (input, expected) ->
            Solution().countSubstrings(input) shouldBe expected
        }
    }
}
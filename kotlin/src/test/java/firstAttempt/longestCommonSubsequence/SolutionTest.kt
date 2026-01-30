package firstAttempt.longestCommonSubsequence

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun longestCommonSubsequence() {
        listOf(
            Pair("abcde", "ace") to 3,
            Pair("abc", "def") to 0,
            Pair("bsbininm", "jmjkbkjkv") to 1,
        ).forEach { (input, expected) ->
            Solution().longestCommonSubsequence(input.first, input.second) shouldBe expected
        }
    }
}
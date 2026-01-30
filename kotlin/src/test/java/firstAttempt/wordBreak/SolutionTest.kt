package firstAttempt.wordBreak

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun wordBreak() {
        listOf(
            Pair("leetcode", listOf("leet", "code")) to true,
            Pair("catsincars", listOf("cats", "cat", "sin", "in", "car")) to false,
            Pair("applepenapple", listOf("apple", "pen", "ape")) to true,
            Pair("abcd", listOf("a", "abc", "b", "cd")) to true
        ).forEach { (input, expected) ->
            Solution().wordBreak(input.first, input.second) shouldBe expected
        }
    }
}
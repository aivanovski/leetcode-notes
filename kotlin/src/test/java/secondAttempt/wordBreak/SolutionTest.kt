package secondAttempt.wordBreak

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun wordBreak() {
        listOf(
            Pair("leetcode", listOf("leet", "code")) to true,
            Pair("applepenapple", listOf("apple","pen")) to true,
            Pair("catsandog", listOf("cats","dog","sand","and","cat")) to false,
        ).forEach { (input, expected) ->
            Solution().wordBreak(input.first, input.second) shouldBe expected
        }
    }
}
package secondAttempt.validAnagram

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isAnagram() {
        listOf(
            Pair("anagram", "nagaram") to true,
        ).forEach { (input, expected) ->
            Solution().isAnagram(input.first, input.second) shouldBe expected
        }
    }
}
package firstAttempt.validAnagram

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun isAnagram() {
        listOf(
            Pair("anagram", "nagaram") to true,
            Pair("rat", "car") to false
        ).forEach { (input, expected) ->
            Solution().isAnagram(input.first, input.second) shouldBe expected
        }
    }
}
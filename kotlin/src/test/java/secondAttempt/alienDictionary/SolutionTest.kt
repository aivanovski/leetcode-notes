package secondAttempt.alienDictionary

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun foreignDictionary() {
        listOf(
            listOf("hrn", "hrf", "er", "enn", "rfnn") to "hernf",
            listOf("abc", "bcd", "cde") to "edabc",
            listOf("bac", "cab", "cbbb", "dc") to "abcd",
            listOf("wrtkj","wrt") to "",
            listOf("z", "z") to "z",
        ).forEach { (input, expected) ->
            Solution().foreignDictionary(input.toTypedArray()) shouldBe expected
        }
    }

}
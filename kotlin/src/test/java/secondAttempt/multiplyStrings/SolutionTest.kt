package secondAttempt.multiplyStrings

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun multiply() {
        listOf(
            Pair("123", "456") to "56088",
            Pair("123", "0") to "0",
        ).forEach { (input, expected) ->
            Solution().multiply(input.first, input.second) shouldBe expected
        }
    }

    @Test
    fun sum() {
        listOf(
            Pair("123", "983") to "1106",
            Pair("123", "344") to "467",
            Pair("123", "0") to "123"
        ).forEach { (input, expected) ->
            Solution().sum(input.first, input.second) shouldBe expected
        }
    }

    @Test
    fun multiplyWithInt() {
        listOf(
            Pair("123", 6) to "738",
            Pair("123", 0) to "0"
        ).forEach { (input, expected) ->
            Solution().multiply(input.first, input.second) shouldBe expected
        }
    }
}
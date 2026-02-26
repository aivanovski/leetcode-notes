package secondAttempt.reverseInteger

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun reverse() {
        listOf(
            123 to 321,
            120 to 21,
            -123 to -321,
            1534236469 to 0,
            1463847412 to 2147483641,
        ).forEach { (input, expected) ->
            Solution().reverse(input) shouldBe expected
        }
    }
}
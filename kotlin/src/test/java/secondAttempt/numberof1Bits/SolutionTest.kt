package secondAttempt.numberof1Bits

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun hammingWeight() {
        listOf(
            11 to 3,
            128 to 1,
            2147483645 to 30
        ).forEach { (input, expected) ->
            Solution().hammingWeight(input) shouldBe expected
        }
    }

}
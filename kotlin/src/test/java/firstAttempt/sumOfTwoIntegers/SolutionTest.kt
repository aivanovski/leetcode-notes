package firstAttempt.sumOfTwoIntegers

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun getSum() {
        listOf(
            Pair(3, 3) to 6,
            Pair(8, 11) to 19,
            Pair(31, 78) to 109,
        ).forEach { (input, expected) ->
            Solution().getSum(input.first, input.second) shouldBe expected
        }
    }
}
package secondAttempt.sumofTwoIntegers

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun getSum() {
        listOf(
            Pair(2, 2) to 4,
            Pair(7, 8) to 15,
        ).forEach { (input, expected) ->
            Solution().getSum(input.first, input.second) shouldBe expected
        }
    }

}
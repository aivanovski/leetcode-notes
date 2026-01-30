package secondAttempt.coinChange

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun coinChange() {
        listOf(
            Pair(listOf(1, 2, 5), 11) to 3,
            Pair(listOf(1), 0) to 0,
        ).forEach { (input, expected) ->
            Solution().coinChange(input.first.toIntArray(), input.second) shouldBe expected
        }
    }

}
package firstAttempt.coinChange

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun coinChange() {
        listOf(
            Pair(listOf(1, 2, 5), 11) to 3,
            Pair(listOf(2), 3) to -1,
        ).forEach { (input, expected) ->
            Solution().coinChange(
                coins = input.first.toIntArray(),
                amount = input.second
            ) shouldBe expected
        }
    }
}
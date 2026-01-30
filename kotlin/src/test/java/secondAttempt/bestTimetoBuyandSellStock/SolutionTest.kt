package secondAttempt.bestTimetoBuyandSellStock

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun maxProfit() {
        listOf(
            listOf(7, 1, 5, 3, 6, 4) to 5,
            listOf(7, 6, 4, 3, 1) to 0,
        ).forEach { (input, expected) ->
            Solution().maxProfit(input.toIntArray()) shouldBe expected
        }
    }

}
package firstAttempt.combinationSum

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun combinationSum() {
        listOf(
            Pair(listOf(2, 3, 6, 7), 7) to listOf(listOf(2, 2, 3), listOf(7))
        ).forEach { (input, expected) ->
            Solution().combinationSum(
                input.first.toIntArray(), input.second
            ) shouldBe expected
        }
    }
}
package secondAttempt.combinationSum

import common.makeSorted
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun combinationSum() {
        listOf(
            Pair(listOf(2, 3, 6, 7), 7) to "[[2,2,3],[7]]",
        ).forEach { (input, expected) ->
            Solution().combinationSum(
                input.first.toIntArray(),
                input.second
            ).makeSorted() shouldBe expected.toTwoDimensionalList().makeSorted()
        }
    }

}
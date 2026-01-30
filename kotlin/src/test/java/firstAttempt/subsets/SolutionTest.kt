package firstAttempt.subsets

import common.makeSorted
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun subsets() {
        listOf(
            listOf(1, 2, 3) to "[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]".toTwoDimensionalList(),
        ).forEach { (input, expected) ->
            Solution().subsets(input.toIntArray()).makeSorted() shouldBe expected.makeSorted()
        }
    }
}
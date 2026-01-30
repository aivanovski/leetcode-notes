package firstAttempt.mergeIntervals

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun merge() {
        listOf(
            listOf(1 to 3, 2 to 6, 8 to 10, 15 to 18) to listOf(1 to 6, 8 to 10, 15 to 18)
        ).forEach { (input, expected) ->
            Solution().merge(input.convertToArrays()) shouldBe expected.convertToArrays()
        }
    }

    private fun List<Pair<Int, Int>>.convertToArrays(): Array<IntArray> {
        return this
            .map { intArrayOf(it.first, it.second) }
            .toTypedArray()
    }
}
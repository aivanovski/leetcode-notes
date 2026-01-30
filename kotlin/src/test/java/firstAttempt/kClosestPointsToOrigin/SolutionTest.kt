package firstAttempt.kClosestPointsToOrigin

import common.toListOfPairs
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun kClosest() {
        listOf(
            Pair("[1,3],[-2,2]", 1) to "[-2,2]",
            Pair("[3,3],[5,-1],[-2,4]", 2) to "[3,3],[-2,4]"
        ).forEach { (input, expected) ->
            Solution().kClosest(
                input.first.toListOfPairs().toArrays(),
                input.second
            ) shouldBe expected.toListOfPairs().toArrays()
        }
    }

    private fun List<Pair<Int, Int>>.toArrays(): Array<IntArray> {
        return this.map { intArrayOf(it.first, it.second) }.toTypedArray()
    }
}
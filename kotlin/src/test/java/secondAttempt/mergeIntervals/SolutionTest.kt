package secondAttempt.mergeIntervals

import common.toArrayOfIntArrays
import common.toListOfPairs
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun merge() {
        listOf(
            "[1,3],[2,6],[8,10],[15,18]" to "[1,6],[8,10],[15,18]",
            "[1,4],[4,5]" to "[1,5]",
            "[4,7],[1,4]" to "[1,7]",
            "" to "",
        ).forEach { (input, expcted) ->
            Solution().merge(
                input.toListOfPairs().toArrayOfIntArrays()
            ) shouldBe expcted.toListOfPairs().toArrayOfIntArrays()
        }
    }
}
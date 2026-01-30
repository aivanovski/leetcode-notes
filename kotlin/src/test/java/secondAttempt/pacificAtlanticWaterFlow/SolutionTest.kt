package secondAttempt.pacificAtlanticWaterFlow

import common.makeSorted
import common.toArrays
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun pacificAtlantic() {
        listOf(
            Pair(
                "[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]",
                "[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]"
            ),
            Pair(
                "[[2,1],[1,2]]",
                "[[0,0],[0,1],[1,0],[1,1]]"
            ),
        ).forEach { (input, expected) ->
            Solution().pacificAtlantic(
                heights = input.toTwoDimensionalList().toArrays()
            ).makeSorted() shouldBe expected.toTwoDimensionalList().makeSorted()
        }
    }
}
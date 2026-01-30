package secondAttempt.graphValidTree

import common.toArrays
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun validTree() {
        listOf(
            Pair(5, "[[0, 1], [0, 2], [0, 3], [1, 4]]") to true,
            Pair(5, "[[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]") to false,
            Pair(5, "[[0,1],[1,3],[3,0],[2,4]]") to false
        ).forEach { (input, expected) ->
            Solution().validTree(
                input.first,
                input.second.toTwoDimensionalList().toArrays()
            ) shouldBe expected
        }
    }

}
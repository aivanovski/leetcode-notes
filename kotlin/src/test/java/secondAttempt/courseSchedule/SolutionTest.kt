package secondAttempt.courseSchedule

import common.toArrays
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun canFinish() {
        listOf(
            Pair("[[1,0]]", 2) to true,
            Pair("[[1,0],[0,1]]", 2) to false,
            Pair("[[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]", 8) to true,
            Pair("[[1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]]", 7) to true,
        ).forEach { (input, expected) ->
            Solution().canFinish(
                input.second,
                input.first.toTwoDimensionalList().toArrays()
            ) shouldBe expected
        }
    }
}
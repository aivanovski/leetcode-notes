package firstAttempt.numberOfConnectedComponentsInUndirectedGraph

import common.toArrays
import common.filterNumbers
import common.splitToPairs
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun countComponents() {
        listOf(
            Pair(3, "[[0,1], [0,2]]") to 1,
            Pair(6, "[0,1], [1,2], [2,3], [4,5]") to 2,
            Pair(1, "") to 1
        ).forEach { (input, expected) ->
            Solution().countComponents(
                input.first,
                input.second.filterNumbers().splitToPairs().toArrays()
            ) shouldBe expected
        }
    }

}
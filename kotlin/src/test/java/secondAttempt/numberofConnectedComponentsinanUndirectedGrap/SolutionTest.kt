package secondAttempt.numberofConnectedComponentsinanUndirectedGrap

import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun countComponents() {
        listOf(
            Pair(6, "[[0,1], [1,2], [2,3], [4,5]]") to 2
        ).forEach { (input, expected) ->
            Solution().countComponents(
                n = input.first,
                edges = input.second
                    .toTwoDimensionalList()
                    .map { intArrayOf(it[0], it[1]) }
                    .toTypedArray()
            ) shouldBe expected
        }
    }

}
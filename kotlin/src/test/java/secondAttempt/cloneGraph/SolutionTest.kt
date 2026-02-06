package secondAttempt.cloneGraph

import common.collect
import common.toNodeGraph
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun cloneGraph() {
        listOf(
            "[[2,4],[1,3],[2,4],[1,3]]" to "[[2,4],[1,3],[2,4],[1,3]]",
        ).forEach { (input, expected) ->
            Solution().cloneGraph(
                input.toTwoDimensionalList().toNodeGraph()
            )?.collect() shouldBe expected.toTwoDimensionalList().toNodeGraph()?.collect()
        }
    }

}
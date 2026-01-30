package firstAttempt.cloneGraph

import common.collect
import common.formatAsGraph
import common.toGraphNodes
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun cloneGraph() {
        listOf(
            "[[2,4],[1,3],[2,4],[1,3]]"
        ).forEach { input ->
            val source = input.toGraphNodes()
            val result = Solution().cloneGraph(source)
            result shouldNotBeSameInstanceAs source
            result.collect().formatAsGraph() shouldBe source.collect().formatAsGraph()
        }
    }

}
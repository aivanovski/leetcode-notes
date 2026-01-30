package firstAttempt.graphValidTree

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun validTree() {
        listOf(
            Pair(5, listOf(0 to 1, 0 to 2, 0 to 3, 1 to 4)) to true,
            Pair(5, listOf(0 to 1, 1 to 2, 2 to 3, 1 to 3, 1 to 4)) to false,
            Pair(5, listOf(0 to 1, 2 to 0, 3 to 0, 1 to 4)) to true,
            Pair(1, listOf(0 to 0)) to false,
        ).forEach { (input, expected) ->
            Solution().validTree(input.first, input.second.toEdges()) shouldBe expected
        }
    }

    private fun List<Pair<Int, Int>>.toEdges(): Array<IntArray> =
        this.map { intArrayOf(it.first, it.second) }
            .toTypedArray()
}
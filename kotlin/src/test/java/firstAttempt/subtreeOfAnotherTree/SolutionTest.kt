package firstAttempt.subtreeOfAnotherTree

import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isSubtree() {
        listOf(
            Pair(listOf(3, 4, 5, 1, 2), listOf(4, 1, 2)) to true,
            Pair(listOf(1), listOf(0)) to false,
            Pair(listOf(1, 1), listOf(1)) to true,
            Pair(
                listOf(
                    1,
                    null,
                    1,
                    null,
                    1,
                    null,
                    1,
                    null,
                    1,
                    null,
                    1,
                    null,
                    1,
                    null,
                    1,
                    null,
                    1,
                    null,
                    1,
                    null,
                    1,
                    2
                ),
                listOf(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            ) to true
        ).forEach { (input, expected) ->
            Solution().isSubtree(
                input.first.toTreeNodes(),
                input.second.toTreeNodes()
            ) shouldBe expected
        }
    }

}
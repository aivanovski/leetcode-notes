package firstAttempt.sameTree

import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isSameTree() {
        listOf(
            Pair(listOf(1, 2, 3), listOf(1, 2, 3)) to true,
            Pair(listOf(1, 2), listOf(1, null, 2)) to false,
        ).forEach { (input, expected) ->
            Solution().isSameTree(
                input.first.toTreeNodes(),
                input.second.toTreeNodes()
            ) shouldBe expected
        }
    }
}
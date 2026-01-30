package secondAttempt.sameTree

import common.toTreeNodes
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun isSameTree() {
        listOf(
            Pair(listOf(1, 2, 3), listOf(1, 2, 3)) to true,
        ).forEach { (input, expected) ->
            Solution().isSameTree(
                input.first.toTreeNodes(),
                input.second.toTreeNodes()
            )
        }
    }
}
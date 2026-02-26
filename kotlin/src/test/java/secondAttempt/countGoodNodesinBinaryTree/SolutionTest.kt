package secondAttempt.countGoodNodesinBinaryTree

import common.toTreeNodes
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun goodNodes() {
        listOf(
            listOf(3, 1, 4, 3, null, 1, 5) to 4,
            listOf(2, null, 4, 10, 8, null, null, 4) to 4,
        ).forEach { (input, expected) ->
            Solution().goodNodes(input.toTreeNodes()) to expected
        }
    }
}
package secondAttempt.invertBinaryTree

import common.collectTreeStructure
import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun invertTree() {
        listOf(
            listOf(4, 2, 7, 1, 3, 6, 9) to listOf(4, 7, 2, 9, 6, 3, 1)
        ).forEach { (input, expected) ->
            Solution().invertTree(input.toTreeNodes())?.collectTreeStructure() shouldBe expected
        }
    }

}
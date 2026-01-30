package secondAttempt.kthSmallestElementinaBST

import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun kthSmallest() {
        listOf(
            Pair(listOf(3, 1, 4, null, 2), 1) to 1,
            Pair(listOf(5, 3, 6, 2, 4, null, null, 1), 3) to 3,
        ).forEach { (input, expected) ->
            Solution().kthSmallest(
                input.first.toTreeNodes(),
                input.second
            ) shouldBe expected
        }
    }

}
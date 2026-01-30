package secondAttempt.reorderList

import common.collect
import common.toNodeList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun reorderList() {
        listOf(
            listOf(1, 2, 3, 4) to listOf(1, 4, 2, 3),
            listOf(1, 2, 3, 4, 5) to listOf(1, 5, 2, 4, 3),
        ).forEach { (input, expected) ->
            val list = input.toNodeList()
            Solution().reorderList(list)
            list.collect() shouldBe expected
        }
    }

}
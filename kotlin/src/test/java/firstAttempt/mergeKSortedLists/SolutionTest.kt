package firstAttempt.mergeKSortedLists

import common.collect
import common.toNodeList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun mergeKLists() {
        listOf(
            listOf(
                listOf(1, 4, 5),
                listOf(1, 3, 4),
                listOf(2, 6),
            ) to listOf(1, 1, 2, 3, 4, 4, 5, 6),
        ).forEach { (input, expected) ->
            Solution().mergeKLists(
                lists = input.map { it.toNodeList() }.toTypedArray()
            )?.collect() shouldBe expected
        }
    }
}
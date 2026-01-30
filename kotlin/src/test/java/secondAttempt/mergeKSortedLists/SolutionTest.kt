package secondAttempt.mergeKSortedLists

import common.collect
import common.toNodeList
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun mergeKLists() {
        listOf(
            "[[1,4,5],[1,3,4],[2,6]]" to listOf(1, 1, 2, 3, 4, 4, 5, 6),
        ).forEach { (input, expected) ->
            Solution().mergeKLists(
                lists = input.toTwoDimensionalList().map { it.toNodeList() }.toTypedArray()
            ).collect() shouldBe expected
        }
    }

}
package firstAttempt.mergeTwoSortedLists

import common.collect
import common.toNodeList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun mergeTwoLists() {
        listOf(
            Pair(listOf(1, 2, 4), listOf(1, 3, 4)) to listOf(1, 1, 2, 3, 4, 4)
        ).forEach { (input, expected) ->
            Solution().mergeTwoLists(
                left = input.first.toNodeList(),
                right = input.second.toNodeList()
            )?.collect() shouldBe expected
        }
    }
}
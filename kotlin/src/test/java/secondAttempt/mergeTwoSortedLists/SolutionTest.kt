package secondAttempt.mergeTwoSortedLists

import common.collect
import common.toNodeList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun mergeTwoLists() {
        listOf(
            Pair(listOf(1, 2, 6), listOf(3, 4, 5)) to listOf(1, 2, 3, 4, 5, 6),
        ).forEach { (input, expected) ->
            Solution().mergeTwoLists(
                input.first.toNodeList(),
                input.second.toNodeList()
            ).collect() shouldBe expected
        }
    }

}
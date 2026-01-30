package secondAttempt.removeNthNodeFromEndofList

import common.collect
import common.toNodeList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun removeNthFromEnd() {
        listOf(
            Pair(listOf(1, 2, 3, 4, 5), 2) to listOf(1, 2, 3, 5),
        ).forEach { (input, expected) ->
            Solution().removeNthFromEnd(
                input.first.toNodeList(), input.second
            )?.collect() shouldBe expected
        }
    }
}
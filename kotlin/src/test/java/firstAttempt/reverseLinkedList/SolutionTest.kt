package firstAttempt.reverseLinkedList

import common.collect
import common.toNodeList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun reverseList() {
        listOf(
            listOf(1, 2, 3, 4, 5)
        ).forEach { input ->
            Solution().reverseList(input.toNodeList())?.collect() shouldBe input.reversed()
        }
    }
}
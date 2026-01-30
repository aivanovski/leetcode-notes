package firstAttempt.threeSum

import common.makeSorted
import io.kotest.matchers.collections.atLeastSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun threeSum() {
        listOf(
            listOf(-1, 0, 1, 2, -1, -4) to listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)),
            listOf(-3, 3, 4, -3, 1, 2) to listOf(listOf(-3, 1, 2)),
            listOf(3, 7, 2, 2, -8, -10) to listOf(listOf(-10, 3, 7)),
        ).forEach { (input, expected) ->
            Solution().threeSum(
                input.toIntArray()
            ).makeSorted() shouldBe expected.makeSorted()
        }
    }
}
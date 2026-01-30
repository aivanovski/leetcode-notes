package firstAttempt.courseSchedule

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun canFinish() {
        listOf(
            Pair(2, listOf(1 to 0)) to true,
            Pair(5, listOf(4 to 3, 4 to 1, 3 to 1, 1 to 0, 2 to 0)) to true,
            Pair(2, listOf(1 to 0, 0 to 1)) to false,
        ).forEach { (input, expected) ->
            val prerequisites = input.second
                .map { intArrayOf(it.first, it.second) }
                .toTypedArray()

            Solution().canFinish(input.first, prerequisites) shouldBe expected
        }
    }
}
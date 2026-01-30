package secondAttempt.nonOverlappingIntervals

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun eraseOverlapIntervals() {
        listOf(
            listOf(1 to 2, 2 to 3, 3 to 4, 1 to 3) to 1,
            listOf(1 to 2, 1 to 2, 1 to 2) to 2,
        ).forEach { (input, expected) ->
            Solution().eraseOverlapIntervals(
                intervals = input.map { intArrayOf(it.first, it.second) }.toTypedArray()
            ) shouldBe expected
        }
    }
}
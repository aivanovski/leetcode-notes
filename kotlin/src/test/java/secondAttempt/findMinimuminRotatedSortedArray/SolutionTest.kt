package secondAttempt.findMinimuminRotatedSortedArray

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun findMin() {
        listOf(
            listOf(3, 4, 5, 1, 2) to 1,
            listOf(0, 1, 2, 3, 4) to 0,
            listOf(4, 5, 6, 7, 0, 1, 2) to 0,
        ).forEach { (input, expected) ->
            Solution().findMin(input.toIntArray()) shouldBe expected
        }
    }
}
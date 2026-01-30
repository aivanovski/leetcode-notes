package firstAttempt.findMinimumInRotatedSortedArray

import io.kotest.matchers.shouldBe
import kotlin.collections.toIntArray
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun findMin() {
        listOf(
            listOf(3, 4, 5, 1, 2) to 1,
            listOf(4, 5, 6, 7, 0, 1, 2) to 0,
            listOf(11, 13, 15, 17) to 11,
            listOf(3, 1, 2) to 1,
        ).forEach { (input, expected) ->
            Solution().findMin(input.toIntArray()) shouldBe expected
        }
    }
}
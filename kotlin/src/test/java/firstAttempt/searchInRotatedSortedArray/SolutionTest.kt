package firstAttempt.searchInRotatedSortedArray

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun search() {
        listOf(
            Pair(listOf(4, 5, 6, 7, 0, 1, 2), 0) to 4,
            Pair(listOf(4, 5, 6, 7, 0, 1, 2), 6) to 2,
            Pair(listOf(4, 5, 6, 7, 0, 1, 2), 3) to -1,
            Pair(listOf(1, 3), 2) to -1,
            Pair(listOf(1, 3, 5), 3) to 1,
            Pair(listOf(4, 5, 6, 7, 0, 1, 2), 5) to 1,
            Pair(listOf(5, 1, 2, 3, 4), 1) to 1
        ).forEach { (input, expected) ->
            Solution().search(input.first.toIntArray(), input.second) shouldBe expected
        }
    }
}
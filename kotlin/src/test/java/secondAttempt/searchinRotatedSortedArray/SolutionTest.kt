package secondAttempt.searchinRotatedSortedArray

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun search() {
        listOf(
            Pair(listOf(4, 5, 6, 7, 0, 1, 2), 0) to 4,
            Pair(listOf(3, 1), 3) to 0,
        ).forEach { (input, expected) ->
            Solution().search(input.first.toIntArray(), input.second) shouldBe expected
        }
    }
}
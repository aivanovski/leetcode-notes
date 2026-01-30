package firstAttempt.longestIncreasingSubsequence

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun lengthOfLIS() {
        listOf(
            listOf(10, 9, 2, 5, 3, 7, 101, 18) to 4,
            listOf(0, 1, 0, 3, 2, 3) to 4,
            listOf(7,7,7,7,7,7,7) to 1,
            listOf(0) to 1,
        ).forEach { (input, expected) ->
            Solution().lengthOfLIS(input.toIntArray()) shouldBe expected
        }
    }
}
package secondAttempt.longestIncreasingSubsequence

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun lengthOfLIS() {
        listOf(
            listOf(10, 9, 2, 5, 3, 7, 101, 18) to 4,
            listOf(1,3,6,7,9,4,10,5,6) to 6,
        ).forEach { (input, expected) ->
            Solution().lengthOfLIS(input.toIntArray()) shouldBe expected
        }
    }
}
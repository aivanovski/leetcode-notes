package firstAttempt.longestConsecutiveSequence

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun longestConsecutive() {
        listOf(
            listOf(100, 4, 200, 1, 3, 2) to 4,
            listOf(0,3,7,2,5,8,4,6,0,1) to 9,
            listOf(1,0,1,2) to 3,
        ).forEach { (input, expected) ->
            Solution().longestConsecutive(input.toIntArray()) shouldBe expected
        }
    }
}
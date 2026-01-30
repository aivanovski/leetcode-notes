package firstAttempt.twoSum

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun twoSum() {
        listOf(
            Pair(intArrayOf(2, 7, 11, 15), 9) to intArrayOf(0, 1),
            Pair(intArrayOf(3,2,4), 6) to intArrayOf(1,2),
        ).forEach { (input, expected) ->
            Solution().twoSum(input.first, input.second) shouldBe expected
        }
    }
}
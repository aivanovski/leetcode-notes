package secondAttempt.climbingStairs

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun climbStairs() {
        listOf(
            2 to 2,
            3 to 3,
        ).forEach { (input, expected) ->
            Solution().climbStairs(input) shouldBe expected
        }
    }
}
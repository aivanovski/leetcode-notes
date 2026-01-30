package secondAttempt.houseRobber

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun rob() {
        listOf(
            listOf(1, 2, 3, 1) to 4,
        ).forEach { (input, expected) ->
            Solution().rob(input.toIntArray()) shouldBe expected
        }
    }
}
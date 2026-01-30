package secondAttempt.jumpGame

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun canJump() {
        listOf(
            listOf(2, 3, 1, 1, 4) to true,
            listOf(3, 2, 1, 0, 4) to false,
        ).forEach { (input, expected) ->
            Solution().canJump(input.toIntArray()) shouldBe expected
        }
    }
}
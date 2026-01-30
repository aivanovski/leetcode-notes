package secondAttempt.houseRobberII

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun rob() {
        listOf(
            listOf(2, 3, 2) to 3,
            listOf(1, 2, 3, 1) to 4,
            listOf(1) to 1,
        ).forEach { (input, expected) ->
            Solution().rob(input.toIntArray()) shouldBe expected
        }
    }

}
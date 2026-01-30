package firstAttempt.houseRobber

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun rob() {
        listOf(
            listOf(1, 2, 3, 1) to 4,
            listOf(2,7,9,3,1) to 12,
        ).forEach { (input, expected) ->
            Solution().rob(input.toIntArray()) shouldBe expected
        }
    }
}
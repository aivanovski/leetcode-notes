package firstAttempt.houseRobberII

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun rob() {
        listOf(
            listOf(2, 3, 2) to 3,
            listOf(1, 2, 3, 1) to 4,
            listOf(2, 1) to 2,
            listOf(1, 2, 1, 1) to 3,
        ).forEach { (input, expected) ->
            Solution().rob(input.toIntArray()) shouldBe expected
        }
    }

}
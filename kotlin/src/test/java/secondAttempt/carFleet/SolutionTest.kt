package secondAttempt.carFleet

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun carFleet() {
        listOf(
            Triple(
                12,
                listOf(10, 8, 0, 5, 3),
                listOf(2, 4, 1, 1, 3)
            ) to 3,
        ).forEach { (input, expected) ->
            Solution().carFleet(
                input.first,
                input.second.toIntArray(),
                input.third.toIntArray()
            ) shouldBe expected
        }
    }

}
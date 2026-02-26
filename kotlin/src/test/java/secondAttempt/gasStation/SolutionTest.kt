package secondAttempt.gasStation

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun canCompleteCircuit() {
        listOf(
            Pair(
                listOf(1, 2, 3, 4, 5),
                listOf(3, 4, 5, 1, 2)
            ) to 3,
        ).forEach { (input, expected) ->
            Solution().canCompleteCircuit(
                input.first.toIntArray(),
                input.second.toIntArray()
            ) shouldBe expected
        }
    }

}
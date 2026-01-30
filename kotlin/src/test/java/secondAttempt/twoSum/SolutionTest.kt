package secondAttempt.twoSum

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun twoSum() {
        listOf(
            Pair(listOf(2, 7, 11, 15), 9) to listOf(0, 1),
        ).forEach { (input, expected) ->
            Solution().twoSum(
                input.first.toIntArray(),
                input.second
            ) shouldBe expected.toIntArray()
        }
    }
}
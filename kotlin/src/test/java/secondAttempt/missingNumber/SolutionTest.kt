package secondAttempt.missingNumber

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun missingNumber() {
        listOf(
            listOf(3, 0, 1) to 2,
            listOf(0, 1) to 2,
            listOf(9,6,4,2,3,5,7,0,1) to 8,
        ).forEach { (input, expected) ->
            Solution().missingNumber(input.toIntArray()) shouldBe expected
        }
    }
}
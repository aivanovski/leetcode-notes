package firstAttempt.missingNumber

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun missingNumber() {
        listOf(
            listOf(3, 0, 1) to 2
        ).forEach { (input, expected) ->
            Solution().missingNumber(input.toIntArray()) shouldBe expected
        }
    }

}
package secondAttempt.containsDuplicate

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun containsDuplicate() {
        listOf(
            listOf(1, 2, 3, 1) to true,
        ).forEach { (input, expected) ->
            Solution().containsDuplicate(input.toIntArray()) shouldBe expected
        }
    }
}
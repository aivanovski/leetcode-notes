package secondAttempt.productofArrayExceptSelf

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun productExceptSelf() {
        listOf(
            listOf(1, 2, 3, 4) to listOf(24, 12, 8, 6),
        ).forEach { (input, expected) ->
            Solution().productExceptSelf(input.toIntArray()).toList() shouldBe expected
        }
    }

}
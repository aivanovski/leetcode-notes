package secondAttempt.maximumProductSubarray

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun maxProduct() {
        listOf(
//            listOf(2, 3, -2, 4) to 6,
//            listOf(-2, -3, -2, 4) to 24,
            listOf(-1, -2, -9, -6) to 108,
        ).forEach { (input, expected) ->
            Solution().maxProduct(input.toIntArray()) shouldBe expected
        }
    }

}
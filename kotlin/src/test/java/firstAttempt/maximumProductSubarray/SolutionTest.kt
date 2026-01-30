package firstAttempt.maximumProductSubarray

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun maxProduct() {
        listOf(
            listOf(2, 3, -2, 4) to 6,
            listOf(-2, 0, -1) to 0,
            listOf(-2) to -2
        ).forEach { (input, expected) ->
            Solution().maxProduct(input.toIntArray()) shouldBe expected
        }
    }

}
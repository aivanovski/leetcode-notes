package secondAttempt.reverseBits

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun reverseBits() {
        listOf(
            43261596 to 964176192,
            2147483644 to 1073741822,
        ).forEach { (input, expected) ->
            Solution().reverseBits(input) shouldBe expected
        }
    }
}
package secondAttempt.decodeWays

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun numDecodings() {
        listOf(
//            "226" to 3,
//            "00" to 0,
            "1123" to 5,
        ).forEach { (input, expected) ->
            Solution().numDecodings(input) shouldBe expected
        }
    }

}
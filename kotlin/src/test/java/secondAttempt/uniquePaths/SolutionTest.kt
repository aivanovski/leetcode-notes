package secondAttempt.uniquePaths

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun uniquePaths() {
        listOf(
            Pair(3, 7) to 28,
        ).forEach { (input, expected) ->
            Solution().uniquePaths(input.first, input.second) shouldBe expected
        }
    }

}
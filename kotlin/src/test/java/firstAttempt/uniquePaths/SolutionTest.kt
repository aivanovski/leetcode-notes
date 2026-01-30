package firstAttempt.uniquePaths

import io.kotest.matchers.shouldBe
import java.sql.SQLOutput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun uniquePaths() {
        listOf(
            Pair(3, 7) to 28,
            Pair(3, 2) to 3,
        ).forEach { (input, expected) ->
            Solution().uniquePaths(input.first, input.second) shouldBe expected
        }
    }
}
package firstAttempt.wordSearch

import common.toGrid
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun exist() {
        listOf(
            Pair(
                """ABCD
                   SFCS
                   ADEE""",
                "ABCCED"
            ) to true,
        ).forEach { (input, expected) ->
            Solution().exist(
                board = input.first.toGrid().data
                    .map { it.toCharArray() }
                    .toTypedArray(),
                word = input.second
            ) shouldBe expected
        }
    }
}
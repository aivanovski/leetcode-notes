package secondAttempt.wordSearch

import common.toCharArrays
import common.toGrid
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun exist() {
        listOf(
            Pair(
                """ABCE
                   SFCS
                   ADEE""",
                "ABCCED"
            ) to true,

            Pair(
                """ABCE
                   SFCS
                   ADEE""",
                "ABCB"
            ) to false,

            Pair(
                """ABCE
                   SFES
                   ADEE""",
                "ABCESEEEFS"
            ) to true,
        ).forEach { (input, expected) ->
            Solution().exist(
                board = input.first.toGrid().toCharArrays(),
                word = input.second
            ) shouldBe expected
        }
    }

}
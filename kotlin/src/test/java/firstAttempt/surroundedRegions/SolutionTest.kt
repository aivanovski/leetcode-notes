package firstAttempt.surroundedRegions

import common.toCharArrays
import common.toGrid
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun solve() {
        listOf(
            Pair(
                """
                |XXXX
                |XOOX
                |XXOX
                |XOXX
                """,
                """
                |XXXX
                |XXXX
                |XXXX
                |XOXX
                """,
            ),

            Pair(
                """
                |OOO
                |OOO
                |OOO
                """,
                """
                |OOO
                |OOO
                |OOO
                """,
            ),
        ).forEach { (input, expected) ->
            val inputBoard = input.toGrid().toCharArrays()
            Solution().solve(inputBoard)
            inputBoard shouldBe expected.toGrid().toCharArrays()
        }
    }

}
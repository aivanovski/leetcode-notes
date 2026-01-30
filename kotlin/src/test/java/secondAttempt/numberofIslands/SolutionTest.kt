package secondAttempt.numberofIslands

import common.asGrid
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun numIslands() {
        listOf(
            """11110
               11010
               11000
               00000""" to 1,

        ).forEach { (input, expected) ->
            Solution().numIslands(input.asGrid()) shouldBe expected
        }
    }

}
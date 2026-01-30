package firstAttempt.setMatrixZeroes

import common.toGrid
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun setZeroes() {
        listOf(
            Pair(
                """111
                   101
                   111""",
                """101
                   000
                   101"""
            )
        ).forEach { (input, expected) ->
            val inputMatrix = input.transformToMatrix()

            Solution().setZeroes(inputMatrix)

            inputMatrix shouldBe expected.transformToMatrix()
        }
    }


    private fun String.transformToMatrix(): Array<IntArray> {
        return this
            .toGrid()
            .data.map { row ->
                row
                    .map { it.digitToInt() }
                    .toIntArray()
            }
            .toTypedArray()
    }
}
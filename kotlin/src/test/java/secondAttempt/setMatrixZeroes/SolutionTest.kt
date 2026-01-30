package secondAttempt.setMatrixZeroes

import common.toArrays
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun setZeroes() {
        listOf(
            "[[1,1,1],[1,0,1],[1,1,1]]" to "[[1,0,1],[0,0,0],[1,0,1]]",
            "[[0,1,2,0],[3,4,5,2],[1,3,1,5]]" to "[[0,0,0,0],[0,4,5,0],[0,3,1,0]]",
        ).forEach { (input, expected) ->
            val matrix = input.toTwoDimensionalList().toArrays()
            Solution().setZeroes(matrix)

            matrix shouldBe expected.toTwoDimensionalList().toArrays()
        }
    }
}
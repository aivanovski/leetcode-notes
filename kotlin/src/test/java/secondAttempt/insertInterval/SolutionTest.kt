package secondAttempt.insertInterval

import common.toArrays
import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun insert() {
        listOf(
            Pair("[[1,3],[6,9]]", 2 to 5) to "[[1,5],[6,9]]",
        ).forEach { (input, expected) ->
            Solution().insert(
                input.first.toTwoDimensionalList().toArrays(),
                input.second.let { intArrayOf(it.first, it.second) }
            ) shouldBe expected.toTwoDimensionalList().toArrays()
        }
    }

}
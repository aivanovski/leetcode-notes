package secondAttempt.threeSum

import common.toTwoDimensionalList
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun threeSum() {
        listOf(
            listOf(-1, 0, 1, 2, -1, -4) to "[[-1,-1,2],[-1,0,1]]",
            listOf(0, 0, 0, 0) to "[[0,0,0]]",
        ).forEach { (input, expected) ->
            val result = Solution().threeSum(input.toIntArray())
            val expectedList = expected.toTwoDimensionalList()

            result.sortAndToSet() shouldBe expectedList.sortAndToSet()
            result.size shouldBe expectedList.size
        }
    }

    private fun List<List<Int>>.sortAndToSet(): Set<List<Int>> {
        return this
            .map { it.sorted() }
            .toSet()
    }
}
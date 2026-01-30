package firstAttempt.insertInterval

import common.filterNumbers
import common.splitToPairs
import common.toArrays
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun insert() {
        listOf(
            Pair("[[1,3],[6,9]]", "[2,5]") to "[[1,5],[6,9]]",
            Pair("[[1,5]]", "[5,7]") to "[[1,7]]",
            Pair("[[1,2],[3,5],[6,7],[8,10],[12,16]]", "[4,8]") to "[[1,2],[3,10],[12,16]]",
            Pair("[[0,0],[1,4],[6,8],[9,11]]", "[0,9]") to "[[0,11]]",
        ).forEach { (input, expected) ->
            Solution().insert(
                intervals = input.first.filterNumbers().splitToPairs().toArrays(),
                newInterval = input.second.filterNumbers().toIntArray()
            ) shouldBe expected.filterNumbers().splitToPairs().toArrays()
        }
    }

}
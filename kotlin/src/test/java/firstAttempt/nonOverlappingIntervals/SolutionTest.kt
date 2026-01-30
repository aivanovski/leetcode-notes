package firstAttempt.nonOverlappingIntervals

import common.toArrays
import common.filterNumbers
import common.splitToPairs
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun eraseOverlapIntervals() {
        listOf(
            "[[1,2],[2,3],[3,4],[1,3]]" to 1,
            "[[1,2],[1,2],[1,2]]" to 2,
            "[[1,100],[11,22],[1,11],[2,12]]" to 2,
            "[[0,2],[1,3],[2,4],[3,5],[4,6]]" to 2,
            """[[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]""" to 7
        ).forEach { (input, expected) ->
            Solution().eraseOverlapIntervals(
                input.filterNumbers().splitToPairs().toArrays()
            ) shouldBe expected
        }
    }

}
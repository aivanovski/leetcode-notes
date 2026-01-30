package firstAttempt.rotateImage

import common.toGrid
import common.toIntArrays
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun rotate() {
        listOf(
//            Pair(
//                """
//                   123
//                   456
//                   789
//                """.toGrid().toIntArrays(),
//                """
//                   741
//                   852
//                   963
//                """.toGrid().toIntArrays()
//            ),
//            Pair(
//                """
//                   12
//                   34
//                """.toGrid().toIntArrays(),
//                """
//                   31
//                   42
//                """.toGrid().toIntArrays()
//            ),
            Pair(
                """
                   1234
                   5678
                   9123
                   4567
                """.toGrid().toIntArrays(),
                """
                   4951
                   5162
                   6273
                   7384
                """.toGrid().toIntArrays()
            )
        ).forEach { (input, expected) ->
            Solution().rotate(input)
            input shouldBe expected
        }
    }
}
package secondAttempt.topKFrequentElements

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun topKFrequent() {
        listOf(
            Pair(listOf(1, 1, 1, 2, 2, 3), 2) to listOf(1, 2),
            Pair(listOf(1, 2, 1, 2, 1, 2, 3, 1, 3, 2), 2) to listOf(1, 2),
        ).forEach { (input, expected) ->
            Solution().topKFrequent(
                input.first.toIntArray(),
                input.second
            ) shouldBe expected.toIntArray()
        }
    }

}
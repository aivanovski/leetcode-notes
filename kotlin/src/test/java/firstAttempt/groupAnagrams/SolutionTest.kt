package firstAttempt.groupAnagrams

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun groupAnagrams() {
        listOf(
            listOf("eat", "tea", "tan", "ate", "nat", "bat") to
                listOf(
                    listOf("bat"),
                    listOf("nat", "tan"),
                    listOf("ate", "eat", "tea"),
                )
        ).forEach { (input, expected) ->
            Solution().groupAnagrams(
                input.toTypedArray()
            ).map { it.toSet() }.toSet() shouldBe expected.map { it.toSet() }.toSet()
        }
    }
}
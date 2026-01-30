package secondAttempt.groupAnagrams

import io.kotest.matchers.shouldBe
import kotlin.collections.map
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun groupAnagrams() {
        listOf(
            Pair(
                listOf("eat", "tea", "tan", "ate", "nat", "bat"),
                listOf(listOf("bat"), listOf("nat", "tan"), listOf("ate", "eat", "tea"))
            ),
        ).forEach { (input, expected) ->
            Solution().groupAnagrams(
                input.toTypedArray()
            ).map { it.toSet() }.toSet() shouldBe expected.map { it.toSet() }.toSet()
        }
    }

}
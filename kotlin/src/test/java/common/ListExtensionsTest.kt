package common

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ListExtensionsTest {
    @Test
    fun `sortSimilarLists should sort list of lists`() {
        listOf(
            listOf(
                listOf(2, 3, 1),
                listOf(2, 2, 5),
                listOf(1, 9, 0),
                listOf(2, 3, 0),
            ) to listOf(
                listOf(1, 9, 0),
                listOf(2, 2, 5),
                listOf(2, 3, 0),
                listOf(2, 3, 1),
            )
        ).forEach { (input, expected) ->
            sortSimilarSizeLists(input) shouldBe expected
        }
    }
}
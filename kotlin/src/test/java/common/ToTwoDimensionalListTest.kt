package common

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ToTwoDimensionalListTest {
    @Test
    fun toTwoDimensionalList() {
        listOf(
            "[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]" to listOf(
                listOf(),
                listOf(1),
                listOf(2),
                listOf(1, 2),
                listOf(3),
                listOf(1, 3),
                listOf(2, 3),
                listOf(1, 2, 3),
            )
        ).forEach { (input, expected) ->
            input.toTwoDimensionalList() shouldBe expected
        }
    }
}
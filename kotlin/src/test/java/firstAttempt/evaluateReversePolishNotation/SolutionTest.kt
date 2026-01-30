package firstAttempt.evaluateReversePolishNotation

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun evalRPN() {
        listOf(
            listOf("2", "1", "+", "3", "*") to 9,
            listOf("4", "13", "5", "/", "+") to 6,
            listOf("10","6","9","3","+","-11","*","/","*","17","+","5","+") to 22
        ).forEach { (input, expected) ->
            Solution().evalRPN(input.toTypedArray()) shouldBe expected
        }
    }
}
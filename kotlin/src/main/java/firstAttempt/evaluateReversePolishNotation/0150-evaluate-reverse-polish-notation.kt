package firstAttempt.evaluateReversePolishNotation

import java.util.LinkedList

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = LinkedList<String>()

        for (token in tokens) {
            if (token.isOperation()) {
                val second = stack.pop()
                val first = stack.pop()

                stack.push(evaluate(token, first, second))
            } else {
                stack.push(token)
            }
        }

        return stack.pop().toInt()
    }

    private fun evaluate(operation: String, first: String, second: String): String {
        val a = first.toInt()
        val b = second.toInt()

        val result = when (operation) {
            "-" -> a - b
            "+" -> a + b
            "*" -> a * b
            "/" -> a / b
            else -> throw IllegalArgumentException("Invalid operation: $operation")
        }

        return result.toString()
    }

    private fun String.isOperation(): Boolean {
        return this in OPERATIONS
    }

    companion object {
        private val OPERATIONS = setOf("-", "+", "/", "*")
    }
}
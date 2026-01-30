package secondAttempt.validParentheses

import java.util.LinkedList

class Solution {
    fun isValid(s: String): Boolean {
        val stack = LinkedList<Char>()

        for (ch in s) {
            val isOpening = (ch == '(' || ch == '{' || ch == '[')
            val last = stack.firstOrNull()

            val isClosingMatched = when {
                ch == ')' && last == '(' -> true
                ch == '}' && last == '{' -> true
                ch == ']' && last == '[' -> true
                else -> false
            }

            if (isOpening) {
                stack.push(ch)
            } else if (isClosingMatched) {
                stack.pop()
            } else {
                return false
            }
        }

        return stack.isEmpty()
    }
}
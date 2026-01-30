package firstAttempt.validParentheses

import java.util.ArrayDeque

// https://leetcode.com/problems/valid-parentheses/description/
class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        // ()[]{}

        for (ch in s) {
            val current: Char? = stack.peek()

            if (ch in OPENING) {
                stack.push(ch)
            } else {
                if (current in OPENING
                    && ((current == '(' && ch == ')')
                        || (current == '[' && ch == ']')
                        || (current == '{' && ch == '}'))
                ) {
                    stack.poll()
                } else {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }

    companion object {
        private val OPENING = setOf('(', '[', '{')
    }
}
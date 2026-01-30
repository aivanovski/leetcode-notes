package firstAttempt.validPalindrome

// https://leetcode.com/problems/valid-palindrome/
class Solution {
    fun isPalindrome(s: String): Boolean {
        val str = s.mapNotNull { char ->
            if (char.isLetter() || char.isDigit()) {
                char.lowercaseChar()
            } else {
                null
            }
        }

        var lhs = 0
        var rhs = str.lastIndex

        while (lhs < rhs) {
            val lhsChar = str[lhs]
            val rhsChar = str[rhs]

            if (lhsChar != rhsChar) {
                return false
            }

            lhs++
            rhs--
        }

        return true
    }
}
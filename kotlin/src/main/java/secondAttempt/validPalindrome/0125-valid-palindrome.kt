package secondAttempt.validPalindrome

class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = s.nextLetterIndex(0, 1)
        var right = s.nextLetterIndex(s.lastIndex, -1)

        while (left <= right && left != -1 && right != -1) {
            val l = s[left].lowercaseChar()
            val r = s[right].lowercaseChar()

            if (l != r) return false

            left = s.nextLetterIndex(left + 1, 1)
            right = s.nextLetterIndex(right - 1, -1)
        }

        return true
    }

    private fun String.nextLetterIndex(start: Int, delta: Int): Int {
        var index = start

        while (index in indices) {
            if (this[index].isLetterOrDigit()) {
                return index
            }

            index += delta
        }

        return if (index in indices) index else -1
    }
}
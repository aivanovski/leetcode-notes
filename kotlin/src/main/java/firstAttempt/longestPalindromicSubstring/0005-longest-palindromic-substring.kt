package firstAttempt.longestPalindromicSubstring

class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""

        val n = s.length
        val dp = Array(n) { BooleanArray(n) }

        // babad
        var maxLength = 1
        var maxPalindrome = s.first().toString()

        for (i in 0 until n) {
            for (j in i downTo 0) {
                val length = i - j + 1

                if (length == 1
                    || (length == 2 && s[i] == s[j])
                    || (s[i] == s[j] && dp.getOrNull(i - 1)?.getOrNull(j + 1) == true)
                ) {
                    dp[i][j] = true
                    if (length > maxLength) {
                        maxLength = length
                        maxPalindrome = s.substring(j, i + 1)
                    }
                }
            }
        }

        return maxPalindrome
    }
}
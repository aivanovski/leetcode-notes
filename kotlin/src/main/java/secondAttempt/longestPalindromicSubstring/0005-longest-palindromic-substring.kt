package secondAttempt.longestPalindromicSubstring

class Solution {
    fun longestPalindrome(s: String): String {
        val n = s.length
        val dp = Array(n) { IntArray(n) }

        // babad
        // 01234
        //   i = 2, j = 2 until 5
        // s[1][2] => s[1] == s[2]

        var maxLength = 1
        var result = s.first().toString()

        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                val length = j - i + 1
                if (length == 1 || (length == 2 && s[i] == s[j])) {
                    dp[i][j] = 1
                } else {
                    dp[i][j] = if (i + 1 < n
                        && j - 1 >= 0
                        && s[i] == s[j]
                        && j - 1 >= i + 1
                        && dp[i + 1][j - 1] == 1
                    ) {
                        1
                    } else {
                        dp[i][j]
                    }
                }

                if (length > maxLength && dp[i][j] == 1) {
                    maxLength = length
                    result = s.substring(i, j + 1)
                }
            }
        }

        return result
    }
}
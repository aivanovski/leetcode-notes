package secondAttempt.palindromicSubstrings

class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length
        val dp = Array(n) { IntArray(n) }

        // abc
        // 012
        //

        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                val length = j - i + 1
                if (length == 1) {
                    dp[i][j] = 1
                } else if (s[i] == s[j] && (length == 2 || (i + 1 < n && dp[i + 1][j - 1] == 1))) {
                    dp[i][j] = 1
                }
            }
        }

        return dp.sumOf { it.sum() }
    }
}
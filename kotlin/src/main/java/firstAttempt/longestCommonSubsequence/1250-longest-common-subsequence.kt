package firstAttempt.longestCommonSubsequence

import kotlin.math.max

class Solution {
    fun longestCommonSubsequence(s1: String, s2: String): Int {
        val n = s1.length
        val m = s2.length
        val dp = Array(n + 1) { IntArray(m + 1) }

        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                dp[i][j] = if (s1[i] == s2[j]) {
                    1 + dp[i + 1][j + 1]
                } else {
                    max(dp[i + 1][j], dp[i][j + 1])
                }
            }
        }

        return dp[0][0]
    }
}
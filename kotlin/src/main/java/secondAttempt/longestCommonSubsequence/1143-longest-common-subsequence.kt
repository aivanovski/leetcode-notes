package secondAttempt.longestCommonSubsequence

class Solution {
    fun longestCommonSubsequence(s1: String, s2: String): Int {
        val n = s1.length
        val m = s2.length

        val dp = Array(n) { IntArray(m) }

        // abcde
        //   ace

        //   ace
        //   ___
        // a|+--
        // b|---
        // c|-+-
        // d|
        // e|

        for (i in 0 until n) {
            for (j in 0 until m) {
                val dpRight = if (j - 1 >= 0) dp[i][j - 1] else 0
                val dpTop = if (i - 1 >= 0) dp[i - 1][j] else 0
                val dpTopRight = if (i - 1 >= 0 && j - 1 >= 0) dp[i - 1][j - 1] else 0

                dp[i][j] = if (s1[i] == s2[j]) {
                    1 + dpTopRight
                } else {
                    maxOf(dpRight, dpTop)
                }
            }
        }

        return dp.last().last()
    }
}
package firstAttempt.palindromicSubstrings

class Solution {
    fun countSubstrings(s: String): Int {
        // aaa

        val n = s.length
        val dp = Array(n) { BooleanArray(n) }
        var count = 0

        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                val length = j - i + 1
                dp[i][j] = (s[i] == s[j] && (length <= 2 || dp[i + 1][j - 1]))
                if (dp[i][j]) {
                    count++
                }
            }
        }

        return count
    }
}
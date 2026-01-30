package firstAttempt.wordBreak

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val n = s.length
        val dp = BooleanArray(n + 1)

        // leetcode
        // 01234567
        // leet
        // code

        for (i in n - 1 downTo 0) {
            for (word in wordDict) {
                if (i + word.length <= n
                    && s.substring(i, i + word.length) == word
                    && !dp[i]
                ) {
                    dp[i] = (i + word.length == n) || dp[i + word.length]
                }
            }
        }

        return dp[0]
    }
}
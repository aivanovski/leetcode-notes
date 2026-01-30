package secondAttempt.wordBreak

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // leetcode
        // 01234567   n=8
        //     1
        //     code
        // leet      i=0,dp[0+4] =1

        // dp[i] = (word match) and (d[i+wordLength] == true or i+wordLength = n)

        val n = s.length
        val dp = BooleanArray(n)

        for (i in n - 1 downTo 0) {
            for (word in wordDict) {
                if (i + word.length > n || dp[i]) continue

                val isWordMatch = (word == s.substring(i, i + word.length))
                dp[i] = isWordMatch && (i + word.length == n || dp[i + word.length])
            }
        }

        return dp.first()
    }
}
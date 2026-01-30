package firstAttempt.decodeWays

// https://leetcode.com/problems/decode-ways/description/
class Solution {
    fun numDecodings(s: String): Int {
        // 12
        //
        // dp[1] = 1
        // dp[2] = 2
        //
        // dp[i] = dp[i-1] + dp[i-2]
        val n = s.length
        val dp = IntArray(n + 1)
        val numberRange = 1..26


        // 11106
        dp[1] = if (s[0] != '0') 1 else 0

        // dp[1] = 1
        // dp[2] = 2
        // dp[3] = 2
        // dp[4] = 2
        // dp[5] =

        for (i in 2..n) {
            val curr = s[i - 1].toString().toInt()
            val prev = s[i - 2].toString().toInt()
            val next = s.getOrNull(i)?.toString()?.toInt()

            if (next == 0) {
                dp[i] = dp[i - 1]
            } else if (curr == 0) {
                if (prev * 10 in numberRange) {
                    dp[i] = dp[i - 1]
                }
            } else {
                dp[i] += dp[i - 1]
                if (prev > 0 && curr + prev * 10 in numberRange) {
                    dp[i] += if (i - 2 == 0) 1 else dp[i - 2]
                }
            }
        }

        return dp[n]
    }
}
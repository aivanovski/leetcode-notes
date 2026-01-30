package firstAttempt.climbingStairs

// https://leetcode.com/problems/climbing-stairs/
class Solution {
    fun climbStairs(n: Int): Int {
        // dp[i] = dp[i-1] + d[i-2]
        if (n <= 1) return 1

        val dp = IntArray(n + 1)
            .apply {
                this[0] = 1
                this[1] = 1
            }

        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}
package secondAttempt.uniquePaths

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }

        // uniques ways
        // dp[i][j] = dp[i][j-1] + dp[i-1][j]

        dp[0][0] = 1
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 && j == 0) continue

                val top = dp[i].getOrNull(j - 1) ?: 0
                val left = dp.getOrNull(i - 1)?.getOrNull(j) ?: 0
                dp[i][j] = top + left
            }
        }

        return dp[m - 1][n - 1]
    }
}
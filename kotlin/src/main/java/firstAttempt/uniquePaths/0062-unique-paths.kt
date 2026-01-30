package firstAttempt.uniquePaths

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val rows = m
        val cols = n

        val dp = Array(
            size = rows,
            init = {
                IntArray(
                    size = cols,
                    init = { 0 }
                )
            })

        dp[0][0] = 1

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                val currDp = dp[r][c]

                if (r + 1 < rows) {
                    dp[r + 1][c] = currDp + dp[r + 1][c]
                }
                if (c + 1 < cols) {
                    dp[r][c + 1] = currDp + dp[r][c + 1]
                }
            }
        }

        return dp[rows - 1][cols - 1]
    }
}
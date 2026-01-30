package firstAttempt.coinChange

// https://leetcode.com/problems/coin-change/description/
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        // 1, 2, 5 to 11
        //
        // dp[i] = for (c in coins) dp[i - 1] + c

        val dp = IntArray(amount + 1)
        val coinsSet = coins.toSet()

        for (i in 1..amount) {
            var minCoinsCount = -1
            // dp[1] = 1 : 1
            // dp[2] = 2 : 1+1,2
            // dp[3] = 3 : 1+1+1,2+1
            // dp[4] = 3

            for (coin in coins) {
                val delta = i - coin

                if (delta == 0) {
                    minCoinsCount = 1
                    break
                } else if (delta > 0 && dp[delta] > 0) {
                    if (minCoinsCount == -1) {
                        minCoinsCount = dp[delta] + 1
                    } else if (dp[delta] + 1 < minCoinsCount) {
                        minCoinsCount = dp[delta] + 1
                    }
                }
            }

            dp[i] = minCoinsCount
        }

        return dp[amount]
    }
}
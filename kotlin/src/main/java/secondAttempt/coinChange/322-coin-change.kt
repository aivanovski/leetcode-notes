package secondAttempt.coinChange

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        // 1 2 5
        // 1: 1
        // 2: (dp[1] + 1) | 1
        // dp[i] = min((dp[i-coin] + 1)  || 1 )
        //    (when dp[i-coin] > 0)      (when i == coin)

        val dp = IntArray(amount + 1, init = { -1 })
        for (i in 1..amount) {
            for (coin in coins) {
                if (i == coin) {
                    dp[i] = 1
                } else if (i - coin > 0) {
                    val prevCoinCount = dp[i - coin]
                    if (prevCoinCount > 0 && (prevCoinCount + 1 < dp[i] || dp[i] == -1)) {
                        dp[i] = prevCoinCount + 1
                    }
                }
            }
        }

        return dp.last()
    }
}
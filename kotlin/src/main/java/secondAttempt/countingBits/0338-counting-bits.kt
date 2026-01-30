package secondAttempt.countingBits

class Solution {
    fun countBits(n: Int): IntArray {
        // 0: 0000
        // 1: 0001
        // 2: 0010    2^1
        // 3: 0011
        // 4: 0100    2^2
        // 5: 0101
        // 6: 0110
        // 7: 0111
        // 8: 1000    2^3

        // 7: dp[i] = dp[7-4] + 1 || 1

        val dp = IntArray(n + 1)
        if (n > 0) dp[1] = 1

        var prevPowerOfTwo = 1
        for (i in 2..n) {
            dp[i] = if (i == prevPowerOfTwo * 2) {
                1
            } else {
                dp[i - prevPowerOfTwo] + 1
            }

            if (i == prevPowerOfTwo * 2) {
                prevPowerOfTwo *= 2
            }
        }

        return dp
    }
}
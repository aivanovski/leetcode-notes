package firstAttempt.countingBits

class Solution {
    fun countBits(n: Int): IntArray {
        val dp = IntArray(n + 1, init = { 0 })

        var powerOfTwo = 1
        for (i in 1..n) {
            dp[i] = if (i == powerOfTwo * 2) {
                powerOfTwo *= 2
                1
            } else {
                dp[i - powerOfTwo] + 1
            }
        }

        return dp
    }
}
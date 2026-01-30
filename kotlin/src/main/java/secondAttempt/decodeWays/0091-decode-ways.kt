package secondAttempt.decodeWays

class Solution {
    fun numDecodings(s: String): Int {
        // 226
        if (s.isEmpty()) return 0

        val n = s.length
        val dp = IntArray(n)

        // 1123
        // 1

        if (s.first() != '0') dp[0] = 1

        for (i in 1 until n) {
            val single = s[i].toString().toInt()
            val double = s.substring(i - 1, i + 1).toInt()

            if (single >= 1 && single <= 9) dp[i] += dp[i - 1]
            if (double >= 10 && double <= 26) {
                if (i == 1) dp[i] += 1
                else dp[i] += dp[i - 2]
            }
        }

        return dp.last()
    }
}
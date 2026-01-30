package secondAttempt.houseRobber

import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        // 1 2 3 1

        // dp[i] = dp[i-1] || dp[i-2] + nums[i]
        val n = nums.size
        val dp = IntArray(n)

        for (i in 0 until n) {
            val prev = dp.getOrNull(i - 1) ?: 0
            val beforePrev = dp.getOrNull(i - 2) ?: 0
            dp[i] = max(prev, beforePrev + nums[i])
        }

        return dp.last()
    }
}
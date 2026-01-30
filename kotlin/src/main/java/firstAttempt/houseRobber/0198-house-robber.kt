package firstAttempt.houseRobber

import kotlin.math.max

// https://leetcode.com/problems/house-robber/description/
class Solution {
    fun rob(nums: IntArray): Int {
        // 1, 2, 3, 1
        //
        // dp[i] = dp[i - 1] || dp[i - 2] + nums[i]

        val n = nums.size
        val dp = IntArray(n + 1)

        dp[1] = nums[0]

        for (i in 2..n) {
            val num = nums[i - 1]
            dp[i] = max(dp[i - 1], dp[i - 2] + num)
        }

        return dp[n]
    }
}
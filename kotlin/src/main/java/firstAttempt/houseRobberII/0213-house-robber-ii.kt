package firstAttempt.houseRobberII

import kotlin.math.max

// https://leetcode.com/problems/house-robber-ii/description/
class Solution {
    fun rob(nums: IntArray): Int {
        // dp[i] = max(dp[i - 1], dp[i-2] + nums[i])

        if (nums.size == 1) return nums.first()

        val dpLeft = calculate(nums, 0, nums.lastIndex - 1)
        val dpRight = calculate(nums, 1, nums.lastIndex)

        return max(dpLeft, dpRight)
    }

    private fun calculate(nums: IntArray, start: Int, end: Int): Int {
        val n = end - start + 1
        val dp = IntArray(n + 1)

        dp[1] = nums[start]

        for (i in 2..n) {
            val num = nums[i + start - 1]
            dp[i] = max(dp[i - 1], dp[i - 2] + num)
        }

        return dp[n]
    }
}
package secondAttempt.houseRobberII

import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size < 2) return nums.firstOrNull() ?: 0

        return max(
            rob(nums, 0, nums.lastIndex - 1),
            rob(nums, 1, nums.lastIndex)
        )
    }

    private fun rob(nums: IntArray, from: Int, to: Int): Int {
        // 0 - 3
        val n = to - from + 1
        val dp = IntArray(n)

        dp[0] = nums[from]

        for (i in 1 until n) {
            dp[i] = max(dp[i - 1], nums[from + i] + (dp.getOrNull(i - 2) ?: 0))
        }

        return dp.last()
    }
}
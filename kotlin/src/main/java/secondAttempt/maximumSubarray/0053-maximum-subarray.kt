package secondAttempt.maximumSubarray

import kotlin.math.max

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        // -2 1 -3 4 -1 2 1 -5 4

        // 1234

        // 0123
        // 0: 1
        // 1: max(dp[0] + nums[1], nums[1]) => 1 + 2 || 2 => 3
        // 2: 3 + 3 || 3 => 6
        // 4: 6 + 4 || 4 => 10

        if (nums.isEmpty()) return 0

        val n = nums.size
        val dp = IntArray(n)
        var maxSum = nums.first()

        for (i in 0 until n) {
            dp[i] = max(
                nums[i] + (dp.getOrNull(i - 1) ?: 0),
                nums[i]
            )
            maxSum = max(dp[i], maxSum)
        }

        return max(dp.last(), maxSum)
    }
}
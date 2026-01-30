package firstAttempt.maximumSubarray

import kotlin.math.max

// https://leetcode.com/problems/maximum-subarray/description/
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        //  5 4 -1 7 8
        // 23
        //  5 9 8 15 23
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums.first()

        val n = nums.size
        val dp = IntArray(n)

        dp[0] = max(0, nums.first())

        var maxSum = nums.first()
        for (i in 1 until n) {
            val num = nums[i]
            dp[i] = max(dp[i - 1] + num, num)

            if (dp[i] >= maxSum) {
                maxSum = dp[i]
            }
        }

        return max(dp[n - 1], maxSum)
    }
}
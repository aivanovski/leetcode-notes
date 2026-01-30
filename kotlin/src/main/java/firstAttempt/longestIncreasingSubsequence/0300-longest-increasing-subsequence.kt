package firstAttempt.longestIncreasingSubsequence

import kotlin.math.max

// https://leetcode.com/problems/longest-increasing-subsequence/description/
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        // 10,9,2,5,3,7,101,18
        //

        val n = nums.size
        val dp = IntArray(n, init = { 1 })
        var maxDp = 1

        for (i in nums.indices) {
            for (j in i + 1..nums.lastIndex) {
                if (nums[j] > nums[i]) {
                    dp[j] = max(dp[i] + 1, dp[j])
                }
                maxDp = max(dp[j], maxDp)
            }
        }

        return maxDp
    }
}
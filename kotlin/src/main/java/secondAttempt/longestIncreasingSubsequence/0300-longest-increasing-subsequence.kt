package secondAttempt.longestIncreasingSubsequence

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        // 10,9,2,5,3,7,101,18
        //  0 1 2 3
        //    i->
        //  j->

        // dp[i] = 1 || max(dp[0..i])
        // 1,3,6,7,9,4,10,5,6

        val n = nums.size
        val dp = IntArray(n, init = { 1 })

        dp[0] = 1

        for (i in 1 until n) {
            for (j in i downTo 0) {
                if (nums[i] > nums[j]) {
                    dp[i] = maxOf(maxOf(dp[j] + 1, 1), dp[i])
                }
            }
        }

        return dp.max()
    }
}
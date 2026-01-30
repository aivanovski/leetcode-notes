package firstAttempt.maximumProductSubarray

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxProduct(nums: IntArray): Int {
        // 2, 3,-2, 4
        // dp[i] = dp[i-1] * nums[i] || nums[i] || dp[i-1]
        if (nums.isEmpty()) return 0

        val dpMax = IntArray(nums.size, init = { 0 })
        val dpMin = IntArray(nums.size, init = { 0 })

        dpMax[0] = nums[0]
        dpMin[0] = nums[0]

        for (i in 1 until nums.size) {
            val num = nums[i]

            dpMax[i] = max(dpMin[i - 1] * num, max(dpMax[i - 1] * num, num))
            dpMin[i] = min(dpMax[i - 1] * num, min(dpMin[i - 1] * num, num))
        }

        return dpMax.max()
    }
}
package firstAttempt.firstMissingPositive

import kotlin.math.abs

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        // 1 2 Int.MAX   n = 3
        // num[1] = -2

        for (i in 0 until n) {
            if (nums[i] <= 0) nums[i] = Int.MAX_VALUE
        }

        for (i in 0 until n) {
            val value = abs(nums[i])
            val index = value - 1
            if (index in nums.indices) {
                nums[index] = -abs(nums[index])
            }
        }

        for (i in 1..n) {
            if (nums[i - 1] > 0) return i
        }

        return n + 1
    }
}
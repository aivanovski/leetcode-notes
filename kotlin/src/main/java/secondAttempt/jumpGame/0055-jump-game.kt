package secondAttempt.jumpGame

import kotlin.math.min

class Solution {
    fun canJump(nums: IntArray): Boolean {
        // 23114
        // 01234

        var minReachable = nums.lastIndex // 4

        for (i in minReachable - 1 downTo 0) {
            val jump = nums[i]

            if (i + jump >= minReachable) {
                minReachable = min(minReachable, i)
            }
        }

        return minReachable == 0
    }
}
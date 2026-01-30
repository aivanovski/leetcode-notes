package secondAttempt.maximumProductSubarray

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxProduct(nums: IntArray): Int {
        // 2 3 -2 4
        // 0: 2
        // 1: 3|6 => 6
        // 2: -2|-12 => -2
        // 4: 4|-8 => 4

        val n = nums.size
        val dpMax = IntArray(n)
        val dpMin = IntArray(n)

        dpMax[0] = nums[0]
        dpMin[0] = nums[0]

        for (i in 1 until n) {
            dpMax[i] = max(max(dpMax[i - 1] * nums[i], nums[i]), dpMin[i - 1] * nums[i])
            dpMin[i] = min(min(dpMin[i - 1] * nums[i], nums[i]), dpMax[i - 1] * nums[i])
        }

//        println("dpMax=${dpMax.toList()}")
//        println("dpMin=${dpMin.toList()}")

        return dpMax.max()
    }
}

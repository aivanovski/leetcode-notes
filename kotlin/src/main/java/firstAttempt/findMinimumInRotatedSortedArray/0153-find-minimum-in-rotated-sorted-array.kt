package firstAttempt.findMinimumInRotatedSortedArray

import kotlin.math.min

class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        // 312
        // l r
        //  lr

        var result = min(nums[left], nums[right])

        while (left < right) {
            val mid = (left + right) / 2
            val leftValue = nums[left]
            val midValue = nums[mid]

            if (midValue > leftValue) {
                left = mid + 1
            } else {
                right = mid - 1
            }

            val nl = nums.getOrElse(left) { nums.first() }
            val nr = nums.getOrElse(right) { nums.first() }

            result = min(min(midValue, result), min(nl, nr))
        }

        return result
    }
}
package secondAttempt.findMinimuminRotatedSortedArray

import kotlin.math.min

class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()

        var left = 0
        var right = nums.lastIndex

        // 34512
        // 01234
        // l m r

        var minValue = nums.first()
        while (left <= right) { // or <=
            val mid = (left + right) / 2

            minValue = min(min(minValue, nums[mid]), min(nums[left], nums[right]))

            if (left == right) break

            if (nums[left] <= nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return minValue
    }
}
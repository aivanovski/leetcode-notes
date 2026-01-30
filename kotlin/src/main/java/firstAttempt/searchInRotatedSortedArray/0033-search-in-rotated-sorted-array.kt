package firstAttempt.searchInRotatedSortedArray

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size <= 1) return nums.indexOf(target)

        val minIndex = findMinValueIndex(nums)

        return if (target in nums[minIndex]..nums[nums.lastIndex]) {
            findTargetIndex(nums, minIndex..nums.lastIndex, target)
        } else {
            findTargetIndex(nums, 0..minIndex, target)
        }
    }

    private fun findTargetIndex(
        nums: IntArray,
        indexes: IntRange,
        target: Int
    ): Int {
        var left = indexes.first
        var right = indexes.last

        while (left < right) {
            val mid = (left + right) / 2

            if (target > nums[mid]) {
                left = mid + 1
            } else if (target < nums[mid]) {
                right = mid - 1
            } else {
                return mid
            }
        }

        return if (nums[left] == target) left else -1
    }

    private fun findMinValueIndex(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        while (left < right) {
            val mid = (left + right) / 2

            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return left
    }
}

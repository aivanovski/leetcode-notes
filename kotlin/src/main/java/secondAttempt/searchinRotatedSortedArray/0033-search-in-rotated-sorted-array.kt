package secondAttempt.searchinRotatedSortedArray

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val pivot = findMinimumIndex(nums)

        return if (pivot > 0 && target >= nums.first() && target <= nums[pivot - 1]) {
            binarySearch(nums, target, 0, pivot)
        } else {
            binarySearch(nums, target, pivot, nums.lastIndex)
        }
    }

    private fun binarySearch(
        nums: IntArray,
        target: Int,
        start: Int,
        end: Int
    ): Int {
        var left = start
        var right = end

        // 4567
        // 0123
        // lm r

        while (left <= right) {
            val mid = (left + right) / 2

            if (nums[mid] == target) return mid
            if (left == right) return -1

            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }

        }

        return -1
    }

    private fun findMinimumIndex(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        // 6701234
        // 4567012

        // 0123456
        // l  m  r
        var minValue = nums.first()
        var minValueIndex = 0

        while (left <= right) {
            val mid = (left + right) / 2

            if (nums[mid] < minValue) {
                minValue = nums[mid]
                minValueIndex = mid
            }
            if (nums[left] < minValue) {
                minValue = nums[left]
                minValueIndex = left
            }
            if (nums[right] < minValue) {
                minValue = nums[right]
                minValueIndex = right
            }

            if (left == right) break

            if (nums[left] > nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return minValueIndex
    }
}
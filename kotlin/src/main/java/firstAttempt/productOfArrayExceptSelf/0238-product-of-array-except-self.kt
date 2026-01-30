package firstAttempt.productOfArrayExceptSelf

// https://leetcode.com/problems/product-of-array-except-self/description/
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val productLeft = IntArray(nums.size)
        val productRight = IntArray(nums.size)
        val result = IntArray(nums.size)

        for (leftIdx in nums.indices) {
            productLeft[leftIdx] = if (leftIdx == 0) {
                nums[0]
            } else {
                productLeft[leftIdx - 1] * nums[leftIdx]
            }

            val rightIdx = (nums.lastIndex - leftIdx)
            productRight[rightIdx] = if (rightIdx == nums.lastIndex) {
                nums[nums.lastIndex]
            } else {
                productRight[rightIdx + 1] * nums[rightIdx]
            }
        }

        for (i in nums.indices) {
            result[i] = when {
                i == 0 -> productRight[i + 1]
                i == nums.lastIndex -> productLeft[i - 1]
                else -> productLeft[i - 1] * productRight[i + 1]
            }
        }

        return result
    }
}
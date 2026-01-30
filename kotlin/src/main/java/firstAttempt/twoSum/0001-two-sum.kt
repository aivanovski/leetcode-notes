package firstAttempt.twoSum

import kotlin.math.max
import kotlin.math.min

// https://leetcode.com/problems/two-sum/description/
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numberToIndicesMap = HashMap<Int, MutableList<Int>>()
        for ((index, num) in nums.withIndex()) {
            val indices = numberToIndicesMap.getOrDefault(num, mutableListOf())
                .apply {
                    add(index)
                }

            numberToIndicesMap[num] = indices
        }

        for ((index, num) in nums.withIndex()) {
            val remain = target - num
            val indices = numberToIndicesMap[remain] ?: continue

            if (remain == num && indices.size >= 2) {
                return intArrayOf(indices[0], indices[1])
            } else if (remain != num) {
                val minIdx = min(index, indices.first())
                val maxIdx = max(index, indices.first())
                return intArrayOf(minIdx, maxIdx)
            }
        }

        return intArrayOf()
    }
}
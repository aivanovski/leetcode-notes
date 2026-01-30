package secondAttempt.twoSum

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToCountMap = HashMap<Int, MutableList<Int>>().apply {
            for ((index, num) in nums.withIndex()) {
                this[num] = this.getOrDefault(num, mutableListOf()).apply {
                    add(index)
                }
            }
        }

        for ((index, num) in nums.withIndex()) {
            val lookup = target - num
            val indexes = numToCountMap[lookup] ?: emptyList()
            if (lookup == num && indexes.size > 1) {
                return intArrayOf(indexes[0], indexes[1])
            } else if (lookup != num && indexes.isNotEmpty()) {
                return intArrayOf(
                    min(index, indexes[0]),
                    max(index, indexes[0])
                )
            }
        }

        return intArrayOf()
    }
}
package firstAttempt.threeSum

// https://leetcode.com/problems/3sum/description/
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        // -1, 0, 1, 2, -1, -4
        // -4, -1, -1, 0, 1, 2
        // *
        nums.sort()

        var i = 0
        while (i < nums.size) {
            val num = nums[i]

            val twoSum = twoSum(
                nums = nums,
                startIndex = i + 1,
                target = -num
            )

            for ((second, third) in twoSum) {
                result.add(listOf(num, second, third))
            }

            while (i < nums.size && num == nums[i]) {
                i++
            }
        }

        return result.toList()
    }

    fun twoSum(
        nums: IntArray,
        startIndex: Int,
        target: Int
    ): List<Pair<Int, Int>> {
        val numToIndicesMap = HashMap<Int, MutableList<Int>>()

        for (i in startIndex..nums.lastIndex) {
            val num = nums[i]
            val indices = numToIndicesMap.getOrDefault(num, mutableListOf())
                .apply {
                    add(i)
                }
            numToIndicesMap[num] = indices
        }

        val result = mutableListOf<Pair<Int, Int>>()
        for (i in startIndex..nums.lastIndex) {
            val num = nums[i]
            val remain = target - num
            val indices = numToIndicesMap[remain] ?: continue

            if ((remain != num && indices.isNotEmpty()
                    || (remain == num && indices.size >= 2))
            ) {
                result.add(num to remain)
                numToIndicesMap.remove(num)
                numToIndicesMap.remove(remain)
            }
        }

        return result
    }
}
package secondAttempt.threeSum

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        // sort array
        // for every distinct nums[i] find: num[j] + nums[k] = -nums[i]

        // -4 -1 -1 0 1 2
        // -2 1 1 1 1 0
        val result = mutableListOf<List<Int>>()

        val n = nums.size
        for (i in 0 until n) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            val target = -nums[i]
            val twoSums = twoSum(target, nums, i + 1)

            twoSums.forEach { (numj, numk) ->
                result.add(listOf(nums[i], numj, numk))
            }
        }

        return result
    }

    private fun twoSum(target: Int, nums: IntArray, startIndex: Int): List<Pair<Int, Int>> {
        val numToIndicesMap = buildNumToIndicesMap(nums, startIndex = startIndex)

        val result = mutableListOf<Pair<Int, Int>>()

        val n = nums.size
        for (i in startIndex until n) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue

            val first = nums[i]
            val second = target - first
            val indices = numToIndicesMap[second] ?: emptySet()

            if (first != second && indices.isNotEmpty()) {
                result.add(first to second)
            } else if (first == second && indices.size >= 2) {
                result.add(first to second)
            }

            numToIndicesMap.remove(first)
        }

        return result
    }

    private fun buildNumToIndicesMap(
        nums: IntArray,
        startIndex: Int
    ): MutableMap<Int, MutableSet<Int>> {
        val numToIndicesMap = mutableMapOf<Int, MutableSet<Int>>()

        for (i in startIndex until nums.size) {
            val num = nums[i]
            numToIndicesMap[num] = numToIndicesMap.getOrDefault(num, mutableSetOf())
                .apply {
                    add(i)
                }
        }

        return numToIndicesMap
    }
}
package firstAttempt.subsets

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        // 1 2 3
        // i = 0
        // [1] | []
        // i = 1
        // [1,2] [1] | [2] []
        // i = 2
        // [1,2,3] [1,2] | [1,3] [1] | [2,3] [2] | [3] []

        val n = nums.size
        val result = mutableListOf<List<Int>>()

        val subset = mutableListOf<Int>()

        fun backtrack(index: Int) {
            if (index >= n) {
                result.add(subset.toList())
                return
            }

            backtrack(index + 1)

            subset.add(nums[index])

            backtrack(index + 1)
            subset.removeLast()
        }

        backtrack(0)

        return result
    }
}
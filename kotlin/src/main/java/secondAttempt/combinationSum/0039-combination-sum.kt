package secondAttempt.combinationSum

class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {

        // 2367
        // 0123
        // 0: [] || [2]
        // 1: [] [3] || [2] [2,3]
        // 2: [] [6] [3] [3,6] || [2] [2,6] [2,3] [2,3,6]

        val n = nums.size
        val result = mutableListOf<List<Int>>()
        val combination = mutableListOf<Int>()

        fun dfs(currIndex: Int, currSum: Int) {
            if (currSum == target) {
                result.add(combination.toList())
                return
            }
            if (currSum > target) return
            if (currIndex >= n) return

            val num = nums[currIndex]

            // include current value
            combination.add(num)
            dfs(currIndex, currSum + num)
            combination.removeLast()

            // not include current value
            dfs(currIndex + 1, currSum)
        }

        dfs(0, 0)

        return result
    }
}
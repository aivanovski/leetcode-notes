package firstAttempt.combinationSum

// https://leetcode.com/problems/combination-sum/description/
class Solution {
    fun combinationSum(source: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        // 2 + [3, 6, 7]
        // 2 + 2  + [3, 6, 7]
        // 2 + 2 + 2  + [3, 6, 7]

        fun dfs(candidates: List<Int>, numbers: List<Int>, sum: Int) {
            if (candidates.isEmpty()) return

            var currSum = sum
            val currNum = candidates.first()
            val currNumbers = numbers.toMutableList()

            while (currSum < target) {
                currSum = currSum + currNum
                currNumbers.add(currNum)

                if (currSum == target) {
                    result.add(currNumbers)
                }

                if (candidates.size > 1) {
                    dfs(candidates.subList(1, candidates.size), currNumbers.toList(), currSum)
                }
            }

            if (candidates.size > 1) {
                dfs(candidates.subList(1, candidates.size), numbers, sum)
            }
        }

        dfs(source.toList(), emptyList(), 0)

        return result
    }
}
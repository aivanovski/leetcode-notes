package firstAttempt.missingNumber

class Solution {

    fun missingNumber(nums: IntArray): Int {
        // 3
        // 1 2 3 =>

        val n = nums.size
        var expectedSum = 0
        var sum = 0
        for (i in 0 until n) {
            sum += nums.getOrNull(i) ?: 0
            expectedSum += (i + 1)
        }

        return expectedSum - sum
    }
}
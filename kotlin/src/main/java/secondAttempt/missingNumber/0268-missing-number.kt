package secondAttempt.missingNumber

class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        val expectedSum = (1..n).sum()
        return expectedSum - nums.sum()
    }
}
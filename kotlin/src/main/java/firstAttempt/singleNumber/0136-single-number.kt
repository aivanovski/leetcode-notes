package firstAttempt.singleNumber

class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.reduce { acc, num -> acc xor num }
    }
}
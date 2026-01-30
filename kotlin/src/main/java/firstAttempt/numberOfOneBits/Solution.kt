package firstAttempt.numberOfOneBits

// https://leetcode.com/problems/number-of-1-bits/description/
class Solution {
    fun hammingWeight(n: Int): Int {
        var count = 0

        for (index in 0..31) {
            val bit = 1.shl(index)

            if (n and bit != 0) {
                count++
            }
        }

        return count
    }
}
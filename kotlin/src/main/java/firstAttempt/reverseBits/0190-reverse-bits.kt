package firstAttempt.reverseBits

class Solution {
    fun reverseBits(n: Int): Int {
        var result = 0

        for (i in 0..31) {
            val readMask = 1 shl i
            val value = if ((n and readMask) != 0) 1 else 0
            result += value shl (31 - i)
        }

        return result
    }
}
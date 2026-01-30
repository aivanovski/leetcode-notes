package secondAttempt.reverseBits

class Solution {
    fun reverseBits(n: Int): Int {
        var result = 0

        for (i in 0..31) {
            val readMask = 1 shl i
            val bit = if ((n and readMask) != 0) 1 else 0
            result = (result shl 1) or bit
        }

        return result
    }
}
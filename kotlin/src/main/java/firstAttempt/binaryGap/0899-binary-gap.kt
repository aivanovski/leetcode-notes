package firstAttempt.binaryGap

import kotlin.math.max

class Solution {
    fun binaryGap(num: Int): Int {
        var maxGap = 0
        var start = -1

        for (i in 0..31) {
            val currBit = getBitValue(num, i)
            val prevBit = if (i > 0) getBitValue(num, i - 1) else null

            if (currBit == 1) {
                if (start >= 0 && (prevBit == 0 || prevBit == 1)) {
                    maxGap = max(maxGap, i - start)
                    start = i
                } else {
                    start = i
                }
            }
        }

        return maxGap
    }

    private fun getBitValue(num: Int, index: Int): Int {
        val mask = 1 shl index
        return if ((num and mask) != 0) 1 else 0
    }
}
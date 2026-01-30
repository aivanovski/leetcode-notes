package firstAttempt.longestRepeatingCharacterReplacement

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        if (s.isEmpty()) return 0

        var start = 0
        var end = 0

        val freqMap = HashMap<Char, Int>()
            .apply {
                put(s.first(), 1)
            }

        var result = 1

        val n = s.length
        for (i in 1 until n) {
            end = i

            val char = s[i]
            freqMap[char] = freqMap.getOrDefault(char, 0) + 1

            val windowLen = end - start + 1 // 2
            val mostFrequentCount = freqMap.values.max() // 1

            result = max(result, min(mostFrequentCount + k, s.length))

            if (windowLen - mostFrequentCount > k) {
                freqMap[s[start]] = freqMap.getOrDefault(s[start], 0) - 1
                start++
            }
        }

        return result
    }
}
package secondAttempt.longestRepeatingCharacterReplacement

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        // AABABBA,  k=1  => 4
        //
        // create char to count map
        //

        val freqMap = HashMap<Char, Int>()
        freqMap[s.first()] = 1

        var left = 0
        var right = 0
        var maxLen = 1

        // AABABBA
        for (i in 1 until s.length) {
            right = i

            val ch = s[right]

            freqMap[ch] = freqMap.getOrDefault(ch, 0) + 1

            val mostFrequentChar = freqMap.entries.maxBy { it.value }.key
            val mostFrequentCount = freqMap[mostFrequentChar] ?: 0

            val len = right - left + 1
            if (len > mostFrequentCount + k) {
                freqMap[s[left]] = freqMap.getOrDefault(s[left], 0) - 1
                left++
            }

            maxLen = maxOf(maxLen, right - left + 1)
        }

        return maxLen
    }
}
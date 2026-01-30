package secondAttempt.longestSubstringWithoutRepeatingCharacters

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        // abcabcbb
        // 01234567

        // [a to 0, b to 1, c to 2]
        //
        val chars = HashSet<Char>()
        var start = 0
        var end = 0

        var maxLength = 0

        for (i in s.indices) {
            val char = s[i]

            if (char in chars) {
                var k = start
                while (s[k] != char) {
                    chars.remove(s[k])
                    k++
                }
                start = k + 1
            }

            chars.add(char)

            end = i
            maxLength = max(maxLength, end - start + 1)
        }

        return maxLength
    }
}
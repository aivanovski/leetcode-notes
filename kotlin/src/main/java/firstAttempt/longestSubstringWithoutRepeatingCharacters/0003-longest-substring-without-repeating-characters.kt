package firstAttempt.longestSubstringWithoutRepeatingCharacters

import kotlin.math.max

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        // iterate over string
        // if s[i] is repeating, slide window
        // else expand window
        if (s.isEmpty()) return 0

        val window = HashSet<Char>()
        var startIndex = 0
        var maxLength = 1


        // pwwkew
        // *
        //  *
        //   *

        for (index in s.indices) {
            val character = s[index]

            if (character in window) {
                while (character in window && startIndex < index) {
                    window.remove(s[startIndex])
                    startIndex++
                }

                maxLength = max(maxLength, index - startIndex + 1)
                window.add(character)
            } else {
                maxLength = max(maxLength, index - startIndex + 1)
                window.add(character)
            }
        }

        return maxLength
    }
}
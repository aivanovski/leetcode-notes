package firstAttempt.validAnagram

// https://leetcode.com/problems/valid-anagram/description/
class Solution {
    fun isAnagram(lhs: String, rhs: String): Boolean {
        val lhsFreq = buildFrequencyArray(lhs)
        val rhsFreq = buildFrequencyArray(rhs)
        return lhsFreq.contentEquals(rhsFreq)
    }

    private fun buildFrequencyArray(text: String): IntArray {
        val result = IntArray(26)
        for (character in text) {
            val index = character - 'a'
            result[index]++
        }
        return result
    }
}
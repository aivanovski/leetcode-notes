package firstAttempt.groupAnagrams

// https://leetcode.com/problems/group-anagrams/description/
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val freqMapToAnagramsMap = LinkedHashMap<FreqMap, MutableList<String>>()

        for (str in strs) {
            val freqMap = createFreqMap(str)
            val anagrams = freqMapToAnagramsMap.getOrDefault(freqMap, mutableListOf())
                .apply {
                    add(str)
                }
            freqMapToAnagramsMap[freqMap] = anagrams
        }

        return freqMapToAnagramsMap.values.toList()
    }

    private fun createFreqMap(str: String): FreqMap {
        val map = HashMap<Char, Int>()

        for (ch in str) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }

        return FreqMap(map)
    }

    data class FreqMap(
        val map: Map<Char, Int>
    )
}
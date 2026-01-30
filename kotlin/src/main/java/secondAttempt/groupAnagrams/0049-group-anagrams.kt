package secondAttempt.groupAnagrams

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val resultMap = HashMap<String, MutableList<String>>()

        for (s in strs) {
            val key = createKey(s)
            resultMap[key] = resultMap.getOrDefault(key, mutableListOf()).apply {
                add(s)
            }
        }

        return resultMap.values.toList()
    }

    private fun createKey(s: String): String {
        val freqArray = IntArray(26).apply {
            for (ch in s) {
                this[ch - 'a'] += 1
            }
        }

        val sb = StringBuilder()
        for (i in freqArray.indices) {
            sb.append(freqArray[i].toChar())
        }

        return sb.toString()
    }
}
package secondAttempt.minimumWindowSubstring

class Solution {
    fun minWindow(s: String, t: String): String {
        val strFreqMap = HashMap<Char, Int>()
        val targetFreqMap = createFreqMap(t)

        var left = 0
        var right = 0
        var minWindowLength = Int.MAX_VALUE
        var minWindow: String = ""

        // ADOBECODEBANC    t=ABC
        for (i in s.indices) {
            val newChar = s[i]

            right = i
            strFreqMap[newChar] = strFreqMap.getOrDefault(newChar, 0) + 1

            while (left < right) {
                val leftChar = s[left]

                val leftCharCurrFreq = strFreqMap[leftChar] ?: 0
                val leftCharTargetFrq = targetFreqMap[leftChar] ?: 0

                if (leftChar !in targetFreqMap || leftCharCurrFreq > leftCharTargetFrq) {
                    strFreqMap[leftChar] = strFreqMap.getOrDefault(leftChar, 0) - 1
                    left++
                } else {
                    break
                }
            }

            if (isFreqMapSatisfied(strFreqMap, targetFreqMap)) {
                val len = right - left + 1
                if (len < minWindowLength) {
                    minWindowLength = minOf(minWindowLength, len)
                    minWindow = s.substring(left, right + 1)
                }
            }
        }

        return minWindow
    }

    private fun createFreqMap(s: String): MutableMap<Char, Int> {
        val map = HashMap<Char, Int>()
        s.forEach { ch ->
            map[ch] = map.getOrDefault(ch, 0) + 1
        }
        return map
    }

    private fun isFreqMapSatisfied(freqMap: Map<Char, Int>, targetMap: Map<Char, Int>): Boolean {
        for (ch in targetMap.keys) {
            if (freqMap.getOrDefault(ch, 0) < targetMap.getOrDefault(ch, 0)) {
                return false
            }
        }

        return true
    }
}
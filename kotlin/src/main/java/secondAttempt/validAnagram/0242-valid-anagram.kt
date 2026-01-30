package secondAttempt.validAnagram

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val smap = createFreqMap(s)
        val tmap = createFreqMap(t)

        for (i in smap.indices) {
            if (smap[i] != tmap[i]) return false
        }

        return true
    }

    private fun createFreqMap(s: String): IntArray {
        return IntArray(26).apply {
            for (ch in s) {
                this[ch - 'a'] += 1
            }
        }
    }
}
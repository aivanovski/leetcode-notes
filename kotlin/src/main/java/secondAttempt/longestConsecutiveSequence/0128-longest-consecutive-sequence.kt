package secondAttempt.longestConsecutiveSequence

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        // 8964321 => 1234
        val numToLengthMap = HashMap<Int, Int>()

        var max = 0
        for (num in nums) {
            if (num in numToLengthMap) continue

            val leftLength = numToLengthMap[num - 1] ?: 0
            val rightLength = numToLengthMap[num + 1] ?: 0

            val length = leftLength + rightLength + 1
            numToLengthMap[num] = length
            numToLengthMap[num - leftLength] = length
            numToLengthMap[num + rightLength] = length

            max = maxOf(max, length)
        }

        return max
    }
}
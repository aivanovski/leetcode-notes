package firstAttempt.topKFrequentElements

import java.util.HashMap
import java.util.PriorityQueue

// https://leetcode.com/problems/top-k-frequent-elements/description/
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val queue =
            PriorityQueue<NumCount>(Comparator { lhs, rhs -> rhs.count.compareTo(lhs.count) })
        val freqMap = HashMap<Int, Int>()

        for (num in nums) freqMap[num] = freqMap.getOrDefault(num, 0) + 1

        val entries = freqMap.entries.map { (num, count) -> NumCount(num, count) }
        queue.addAll(entries)

        val result = IntArray(k)
        for (i in 0 until k) {
            result[i] = queue.poll().num
        }

        return result
    }

    data class NumCount(
        val num: Int,
        val count: Int
    )
}
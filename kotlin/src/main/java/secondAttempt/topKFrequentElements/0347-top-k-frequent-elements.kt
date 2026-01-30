package secondAttempt.topKFrequentElements

import java.util.PriorityQueue

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val countMap = HashMap<Int, Int>()
            .apply {
                for (num in nums) this[num] = getOrDefault(num, 0) + 1
            }

        val heap = PriorityQueue<Pair<Int, Int>>(
            Comparator { lhs, rhs -> -lhs.second.compareTo(rhs.second) }
        )
        heap.addAll(countMap.entries.map { (key, value) -> key to value })

        return IntArray(k) { heap.poll().first }
    }
}
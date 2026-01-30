package secondAttempt.nonOverlappingIntervals

import java.util.LinkedList
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it.first() }

        // 1 to 2, 1 to 3, 2 to 3, 3 to 4

        val merged = LinkedList<IntArray>().apply {
            intervals.firstOrNull()?.let { add(it) }
        }

        for (i in 1 until intervals.size) {
            val interval = intervals[i]
            if (merged.isEmpty()) merged.add(interval)

            if (isOverlap(merged.last(), interval)) {
                if (interval[1] < merged.last()[1]) {
                    merged.removeLast()
                    merged.addLast(interval)
                }
            } else {
                merged.add(interval)
            }
        }

        return intervals.size - merged.size
    }

    private fun isOverlap(lhs: IntArray, rhs: IntArray): Boolean {
        return (lhs[0] > rhs[0] && lhs[0] < rhs[1])
            || (lhs[1] > rhs[0] && lhs[1] < rhs[1])
            || (rhs[0] > lhs[0] && rhs[0] < lhs[1])
            || (rhs[1] > lhs[0] && rhs[1] < lhs[1])
            || (lhs.contentEquals(rhs))
    }
}
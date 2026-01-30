package secondAttempt.mergeIntervals

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        // sort by start
        // for i in intervals
        //   if (i intersects result.last()) merge(i, result.last) else result.add(i)
        // O(nlogn + n) => O(nlogn)
        if (intervals.size < 2) return intervals

        intervals.sortBy { it.first() }

        val result = mutableListOf<IntArray>()
            .apply {
                add(intervals.first())
            }

        for (i in 1 until intervals.size) {
            val interval = intervals[i]
            if (interval.intersects(result.last())) {
                result[result.lastIndex] = interval.merge(result.last())
            } else {
                result.add(interval)
            }
        }

        return result.toTypedArray()
    }

    private fun IntArray.merge(another: IntArray): IntArray {
        return intArrayOf(min(this[0], another[0]), max(this[1], another[1]))
    }

    private fun IntArray.intersects(another: IntArray): Boolean {
        val first = IntRange(this[0], this[1])
        val second = IntRange(another[0], another[1])
        return second.contains(first.first)
            || second.contains(first.last)
            || first.contains(second.first)
            || first.contains(second.last)
    }
}

package firstAttempt.mergeIntervals

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { interval -> interval.first() }

        val mergedIntervals = mutableListOf<IntArray>()

        for (interval in intervals) {
            val last = mergedIntervals.lastOrNull()

            if (last != null && intersects(interval, last)) {
                mergedIntervals[mergedIntervals.lastIndex] = merge(interval, last)
            } else {
                mergedIntervals.add(interval)
            }
        }

        return mergedIntervals.toTypedArray()
    }

    private fun merge(first: IntArray, second: IntArray): IntArray {
        return intArrayOf(
            min(first.start, second.start),
            max(first.end, second.end)
        )
    }

    private fun intersects(first: IntArray, second: IntArray): Boolean {
        return (first.start >= second.start && first.start <= second.end)
            || (first.end >= second.start && first.end <= second.end)
            || (second.start >= first.start && second.start <= first.end)
            || (second.end >= first.start && second.end <= first.end)
    }

    private val IntArray.start: Int
        get() = this[0]

    private val IntArray.end: Int
        get() = this[1]

}
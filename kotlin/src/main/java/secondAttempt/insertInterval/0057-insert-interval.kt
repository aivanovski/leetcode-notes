package secondAttempt.insertInterval

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun insert(
        intervals: Array<IntArray>,
        newInterval: IntArray
    ): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(newInterval)

        intervals.sortBy { it.first() }

        // -1 to 1, 2 to 3, 6 to 9
        //     4 to 5
        val result = mutableListOf<IntArray>()
            .apply {
                add(newInterval)
            }

        for (interval in intervals) {
            val last = result.last()

            if (intersects(interval, last)) {
                result[result.lastIndex] = merge(last, interval)
            } else if (interval.isBefore(last)) {
                result.add(result.lastIndex, interval)
            } else {
                result.add(interval)
            }
        }

        return result.toTypedArray()
    }

    private fun IntArray.isBefore(another: IntArray): Boolean =
        !intersects(this, another) && this[1] < another[0]

    private fun intersects(first: IntArray, second: IntArray): Boolean {
        return (first.contentEquals(second))
            || first[0].isInside(second)
            || first[1].isInside(second)
            || second[0].isInside(first)
            || second[1].isInside(first)
    }

    private fun merge(first: IntArray, second: IntArray): IntArray {
        first[0] = min(first[0], second[0])
        first[1] = max(first[1], second[1])
        return first
    }

    private fun Int.isInside(interval: IntArray): Boolean {
        return this >= interval[0] && this <= interval[1]
    }
}
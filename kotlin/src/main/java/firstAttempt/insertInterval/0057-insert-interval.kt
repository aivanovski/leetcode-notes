package firstAttempt.insertInterval

import kotlin.math.max
import kotlin.math.min

// https://leetcode.com/problems/insert-interval/description/
class Solution {
    fun insert(
        intervals: Array<IntArray>,
        newInterval: IntArray
    ): Array<IntArray> {
        if (intervals.isEmpty()) {
            return arrayOf(newInterval)
        }

        // if non overlapped -> find index to insert
        // else -> find start ind end index and merge

        if (newInterval.isBefore(intervals.first())) {
            return intervals.toMutableList()
                .apply {
                    add(0, newInterval)
                }
                .toTypedArray()
        }

        val result: MutableList<IntArray> = ArrayList<IntArray>(intervals.size)
            .apply {
                add(newInterval)
            }

        for (interval in intervals) {
            val current = result.last()

            if (isOverlapped(interval, current)) {
                result[result.lastIndex] = merge(interval, current)
            } else if (interval.isAfter(current)) {
                result.add(interval)
            } else if (interval.isBefore(current)) {
                result.add(result.lastIndex, interval)
            }
        }

        return result.toTypedArray()
    }

    private fun isOverlapped(
        interval: IntArray,
        other: IntArray
    ): Boolean {
        return interval.contains(other.start)
            || interval.contains(other.end)
            || other.contains(interval.start)
            || other.contains(interval.end)
    }

    private fun IntArray.isBefore(interval: IntArray): Boolean {
        return this.end < interval.start
    }

    private fun IntArray.isAfter(interval: IntArray): Boolean {
        return this.start > interval.end
    }

    private fun merge(
        interval: IntArray,
        other: IntArray
    ): IntArray = intArrayOf(
        min(interval.start, other.start),
        max(interval.end, other.end)
    )

    private fun IntArray.contains(value: Int): Boolean =
        value >= this.start && value <= this.end

    val IntArray.start: Int
        get() = this[0]

    val IntArray.end: Int
        get() = this[1]
}
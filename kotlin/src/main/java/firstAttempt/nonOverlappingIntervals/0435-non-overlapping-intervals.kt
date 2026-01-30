package firstAttempt.nonOverlappingIntervals

// https://leetcode.com/problems/non-overlapping-intervals/description/
class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val sorted = intervals
            .map { Interval(it[0], it[1]) }
            .sortedBy { it.start }

        val nonOverlapped = mutableListOf(sorted.first())
        var removedCount = 0

        //[[0,2],[1,3],[2,4],[3,5],[4,6]]

        for (index in 1..sorted.lastIndex) {
            val last = nonOverlapped.last()
            val interval = sorted[index]

            if (isOverlapped(last, interval)) {
                if (interval.end < last.end) {
                    nonOverlapped[nonOverlapped.lastIndex] = interval
                }
                removedCount++
            } else {
                nonOverlapped.add(interval)
            }
        }

        return removedCount
    }

    private fun isOverlapped(first: Interval, second: Interval): Boolean {
        return (first == second)
            || second.contains(first.start)
            || second.contains(first.end)
            || first.contains(second.start)
            || first.contains(second.end)
    }

    data class Interval(val start: Int, val end: Int)

    fun Interval.contains(value: Int): Boolean =
        (value > start && value < end)
}
package firstAttempt.longestConsecutiveSequence

import kotlin.math.max
import kotlin.math.min

// https://leetcode.com/problems/longest-consecutive-sequence/description/
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        // 100,4,200,1,3,2

        val intervals = HashMap<Int, Interval>()
        var maxLength = 0

        for (num in nums) {
            if (intervals.containsKey(num)) continue

            val prevInterval = intervals[num - 1]
            val nextInterval = intervals[num + 1]

            if (prevInterval != null) {
                intervals.remove(prevInterval.start)
                intervals.remove(prevInterval.end)
            }

            if (nextInterval != null) {
                intervals.remove(nextInterval.start)
                intervals.remove(nextInterval.end)
            }

            val interval = when {
                prevInterval != null && nextInterval != null -> {
                    val merged = merge(prevInterval, nextInterval)
                    intervals[merged.start] = merged
                    intervals[merged.end] = merged

                    merged
                }

                prevInterval != null || nextInterval != null -> {
                    val interval = prevInterval ?: nextInterval!!
                    val merged = Interval(min(interval.start, num), max(interval.end, num))
                    intervals[merged.start] = merged
                    intervals[merged.end] = merged

                    merged
                }

                else -> {
                    val interval = Interval(num, num)
                    intervals[num] = interval

                    interval
                }
            }

            val length = interval.end - interval.start + 1
            if (length > maxLength) {
                maxLength = length
            }
        }

        return maxLength
    }

    private fun merge(first: Interval, second: Interval): Interval {
        return Interval(min(first.start, second.start), max(first.end, second.end))
    }

    data class Interval(val start: Int, val end: Int)
}
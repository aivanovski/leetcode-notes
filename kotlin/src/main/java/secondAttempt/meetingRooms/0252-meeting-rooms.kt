package secondAttempt.meetingRooms

import common.Interval

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        // (0,30),(5,10),(15,20)
        val sortedIntervals = intervals.sortedBy { interval -> interval.start }

        val n = sortedIntervals.size
        for (i in 1 until n) {
            val prev = sortedIntervals[i - 1]
            val curr = sortedIntervals[i]
            if (prev.end > curr.start) return false
        }

        return true
    }
}
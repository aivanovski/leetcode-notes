package secondAttempt.meetingRoomsII

import common.Interval
import java.util.LinkedList
import kotlin.math.max

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        // (0 to 40), (5 to 10), (15 to 20)
        // 0                  40
        //    5  10  15 20
        // 0 -> 1
        // 5 -> 2
        // 10 -> 1
        // 15 -> 2
        // 20 -> 1
        // 40 -> 0

        val starts = LinkedList(intervals.map { it.start }.sorted())
        val ends = LinkedList(intervals.map { it.end }.sorted())

        var maxRooms = 0
        var rooms = 0

        while (starts.isNotEmpty() || ends.isNotEmpty()) {
            val start = starts.firstOrNull()
            val end = ends.firstOrNull()

            if (start != null && end != null) {
                if (start < end) {
                    starts.removeFirst()
                    rooms++
                } else if (start > end) {
                    ends.removeFirst()
                    rooms--
                } else {
                    starts.removeFirst()
                    ends.removeFirst()

                }

                maxRooms = max(maxRooms, rooms)
            } else {
                break
            }
        }

        return maxRooms
    }
}

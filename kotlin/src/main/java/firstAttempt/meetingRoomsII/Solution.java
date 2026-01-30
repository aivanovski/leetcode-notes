package firstAttempt.meetingRoomsII;

import firstAttempt.meetingRooms.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // rooms = [[]]
        // for (t in allTimes)
        //      if (t from startTime) activeMeetings++
        //      else activeMeetings--
        //      maxMeetings = max(..)

        // Complexity: O(n)
        var startTime = new LinkedList<Integer>();
        var endTime = new LinkedList<Integer>();
        for (var interval : intervals) {
            startTime.add(interval.start);
            endTime.add(interval.end);
        }

        startTime.sort(Comparator.comparing(value -> value));
        endTime.sort(Comparator.comparing(value -> value));

        var maxCount = 0;
        var count = 0;
        while (!startTime.isEmpty() || !endTime.isEmpty()) {
            var start = (startTime.size() > 0) ? startTime.get(0) : null;
            var end = (endTime.size() > 0) ? endTime.get(0) : null;

            if (start != null && end != null) {
                if (start < end) {
                    startTime.remove(0);
                    count++;
                } else if (start > end) {
                    endTime.remove(0);
                    count--;
                } else { // start == end
                    startTime.remove(0);
                    endTime.remove(0);
                }

            } else if (start != null) {
                startTime.remove(0);
                count++;
            } else {
                endTime.remove(0);
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
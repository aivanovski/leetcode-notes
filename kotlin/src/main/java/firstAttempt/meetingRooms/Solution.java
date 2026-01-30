package firstAttempt.meetingRooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        var merged = new ArrayList<Interval>();

        intervals.sort(Comparator.comparingInt(lhs -> lhs.start));

        for (var interval : intervals) {
            Interval last = null;
            if (!merged.isEmpty()) {
                last = merged.get(merged.size() - 1);
            }

            if (last != null && intersects(last, interval)) {
                merged.set(merged.size() - 1, merge(last, interval));
            } else {
                merged.add(interval);
            }
        }

        return merged.size() == intervals.size();
    }

    private Interval merge(Interval first, Interval second) {
        return new Interval(Math.min(first.start, second.start), Math.max(first.end, second.end));
    }

    private boolean intersects(Interval first, Interval second) {
        return isInside(first, second.start) ||
                isInside(first, second.end) ||
                isInside(second, first.start) ||
                isInside(second, first.end) ||
                (first.start == second.start && first.end == second.end);
    }

    private boolean isInside(Interval interval, int value) {
        return value > interval.start && value < interval.end;
    }
}


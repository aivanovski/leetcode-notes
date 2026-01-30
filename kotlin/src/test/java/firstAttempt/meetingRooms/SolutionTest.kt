package firstAttempt.meetingRooms

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun meetingRooms() {
        listOf(
            listOf(0 to 30, 5 to 10, 15 to 20) to false,
            listOf((5 to 8), (9 to 15)) to true,
            listOf(0 to 30, 0 to 30) to false
        ).forEach { (input, expected) ->
            val intervals = input.map { Interval(it.first, it.second) }

            Solution().canAttendMeetings(intervals) shouldBe expected
        }
    }
}
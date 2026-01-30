package firstAttempt.meetingRoomsII

import firstAttempt.meetingRooms.Interval
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun minMeetingRooms() {
        listOf(
            listOf(0 to 40, 5 to 10, 15 to 20) to 2,
        ).forEach { (input, expected) ->
            Solution().minMeetingRooms(
                input.map { Interval(it.first, it.second) }
            ) shouldBe expected
        }
    }
}
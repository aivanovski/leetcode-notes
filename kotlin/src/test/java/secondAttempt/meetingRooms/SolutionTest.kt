package secondAttempt.meetingRooms

import common.Interval
import common.toArrayOfIntArrays
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun canAttendMeetings() {
        listOf(
            listOf(
                (0 to 30), (5 to 10), (15 to 20)
            ) to false,
            listOf(
                (5 to 8), (9 to 15)
            ) to true,
        ).forEach { (input, expected) ->
            Solution().canAttendMeetings(
                intervals = input.map { Interval(it.first, it.second) }
            ) shouldBe expected
        }
    }

}
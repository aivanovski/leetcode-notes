package firstAttempt.containsDuplicate

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun containsDuplicate() {
        Solution().containsDuplicate(intArrayOf(1, 2, 3, 1)) shouldBe true
        Solution().containsDuplicate(intArrayOf(1, 2, 3, 4)) shouldBe false
        Solution().containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)) shouldBe true
    }
}
package firstAttempt.encodeAndDecodeStrings

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun encodeAndDecode() {
        listOf(
            listOf("neet", "code", "love", "you"),
            listOf("we","say",":","yes"),
            listOf("we","",":","yes"),
        ).forEach { input ->
            val solution = Solution()
            solution.decode(solution.encode(input)) shouldBe input
        }
    }
}
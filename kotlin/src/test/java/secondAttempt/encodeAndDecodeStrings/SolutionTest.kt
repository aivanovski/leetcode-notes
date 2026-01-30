package secondAttempt.encodeAndDecodeStrings

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun encodeAndDecode() {
        listOf(
            listOf("Hello", "World"),
            listOf(""),
            listOf("Apple", "", "Pineapple")
        ).forEach { input ->
            val codec = Solution()
            codec.decode(codec.encode(input)) shouldBe input
        }
    }
}
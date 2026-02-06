package secondAttempt.findMedianfromDataStream

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class MedianFinderTest {
    @Test
    fun findMedian() {
//        with(MedianFinder()) {
//            addNum(1)
//            addNum(2)
//            findMedian() shouldBe 1.5
//            addNum(3)
//            findMedian() shouldBe 2.0
//        }

        with(MedianFinder()) {
            addNum(1)
            findMedian() shouldBe 1.0
            addNum(2)
            findMedian() shouldBe 1.5
            addNum(3)
            findMedian() shouldBe 2.0
            addNum(4)
            findMedian() shouldBe 2.5
            addNum(5)
            findMedian() shouldBe 3.0
            addNum(6)
            findMedian() shouldBe 3.5
            addNum(7)
            findMedian() shouldBe 4.0
            addNum(8)
            findMedian() shouldBe 4.5
            addNum(9)
            findMedian() shouldBe 5.0
            addNum(10)
            findMedian() shouldBe 5.5
        }
    }
}
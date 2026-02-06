package secondAttempt.findMedianfromDataStream

import java.util.PriorityQueue

class MedianFinder {

    private val leftHeap = PriorityQueue<Int>(compareByDescending { it })
    private val rightHeap = PriorityQueue<Int>(compareBy { it })

    fun addNum(num: Int) {
        leftHeap.add(num)

        if (leftHeap.isNotEmpty() && rightHeap.isNotEmpty()) {
            while (leftHeap.first() > rightHeap.first()) {
                rightHeap.add(leftHeap.poll())
            }
        }

        while (leftHeap.size - rightHeap.size > 1) {
            rightHeap.add(leftHeap.poll())
        }

        while (rightHeap.size - leftHeap.size > 1) {
            leftHeap.add(rightHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (leftHeap.size == rightHeap.size) {
            (leftHeap.first() + (rightHeap.firstOrNull() ?: 0)) / 2.0
        } else if (leftHeap.size > rightHeap.size) {
            leftHeap.first().toDouble()
        } else {
            rightHeap.first().toDouble()
        }
    }
}


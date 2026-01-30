package firstAttempt.kClosestPointsToOrigin

import java.util.PriorityQueue

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        // build heap by squared distance O(n)
        // poll k points O(klogn + n)

        val heap = PriorityQueue<IntArray>(compareBy { it.calculateSquaredDistance() })
        heap.addAll(points)

        val result = mutableListOf<IntArray>()
        while (result.size < k) {
            result.add(heap.poll())
        }

        return result.toTypedArray()
    }

    private fun IntArray.calculateSquaredDistance(): Int {
        return this[0] * this[0] + this[1] * this[1]
    }
}